package br.com.szella.novaluna.service.impl;

import br.com.szella.novaluna.dto.JogadorDto;
import br.com.szella.novaluna.dto.PecaDto;
import br.com.szella.novaluna.dto.PosicaoDto;
import br.com.szella.novaluna.dto.TabuleiroDto;
import br.com.szella.novaluna.enums.CorJogadorEnum;
import br.com.szella.novaluna.exception.JogoException;
import br.com.szella.novaluna.service.CargaInicialService;
import br.com.szella.novaluna.service.JogoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JogoServiceImpl implements JogoService {

    private final CargaInicialService cargaInicialService;
    private List<JogadorDto> jogadores = new ArrayList<JogadorDto>();
    private List<PecaDto> pecas;
    private TabuleiroDto tabuleiro;


    @Override
    public void inserirJogador(JogadorDto jogador) {

        if (null != this.tabuleiro) {
            throw new JogoException("Partida iniciada!");
        }

        if (jogadores.stream().anyMatch(jogadorFilter -> jogadorFilter.getCor().equals(jogador.getCor()))) {
            jogadores = jogadores.stream()
                    .map(jogadorMap ->
                            jogadorMap.getCor().equals(jogador.getCor())
                                    ? jogador : jogadorMap)
                    .collect(Collectors.toList());
        } else {
            jogadores.add(jogador);
        }

        System.out.println("fim");
    }

    @Override
    public List<JogadorDto> todosJogadores() {
        return jogadores;
    }

    @Override
    public void iniciarPartida() {
        if (jogadores.size() == 0) {
            throw new JogoException("Registre um jogador!");
        } else if (null != this.tabuleiro) {
            throw new JogoException("Joga já foi iniciado!");
        }

        this.pecas = cargaInicialService.iniciarPecas();
        this.tabuleiro = TabuleiroDto.builder()
                .posicaoLua(0)
                .ultimaPosicao(0)
                .pecas(new PecaDto[12])
                .casas(cargaInicialService.carregarCasa())
                .build();

        Collections.shuffle(jogadores);

        jogadores.forEach((a) -> {
            this.tabuleiro.getCasas()[0].getJogadores().add(a);
        });

        carregarPecasTabuleiro();

        setUltimoJogador();
    }

    @Override
    public void pegarPeca(CorJogadorEnum corJogador, int posicaoPeca, int posicaoX, int posicaoY) {
        var peca = pegarPecaTabuleiro(posicaoPeca);
        var jogador = pegarJogador(corJogador);
        var posicao = PosicaoDto.builder().x(posicaoX).y(posicaoY).build();

        jogador
                .getPecas()
                .put(posicao, peca);

        this.tabuleiro
                .setPosicaoLua(posicaoPeca);

        this.tabuleiro
                .getCasas()[jogador.getCasa()]
                .getJogadores()
                .removeIf(jogadorFilter -> jogadorFilter.getCor().equals(jogador.getCor()));

        setNovaCasa(peca, jogador);

        if (this.tabuleiro.getCasas()[this.tabuleiro.getUltimaPosicao()].getJogadores().isEmpty()) {
            setUltimaPosicao();
        }

        this.tabuleiro
                .getCasas()[jogador.getCasa()]
                .getJogadores()
                .add(jogador);

        setUltimoJogador();
    }

    @Override
    public TabuleiroDto tabuleiro() {
        return this.tabuleiro;
    }

    private void setUltimaPosicao() {
        var ultimaPosicao = this.tabuleiro.getUltimaPosicao();
        while (true) {
            if (!this.tabuleiro.getCasas()[ultimaPosicao].getJogadores().isEmpty()) {
                this.tabuleiro.setUltimaPosicao(ultimaPosicao);

                break;
            }
            ultimaPosicao = getCasaVoltaTabuleiro(++ultimaPosicao);
        }
    }

    private void setUltimoJogador() {
        var ultimaPosicao = this.tabuleiro.getUltimaPosicao();
        var jogadores = this.tabuleiro.getCasas()[ultimaPosicao].getJogadores();
        var ultimoJogador = jogadores.get(jogadores.size() - 1);

        this.tabuleiro.setUltimojogador(ultimoJogador);
    }

    private void setNovaCasa(PecaDto peca, JogadorDto jogador) {
        var soma = jogador.getCasa() + peca.getPassos();
        var novaCasa = getCasaVoltaTabuleiro(soma);

        jogador.setCasa(novaCasa);
    }

    private static int getCasaVoltaTabuleiro(int valor) {
        return valor < 24 ? valor : valor - 24;
    }


    private void carregarPecasTabuleiro() {
        for (int i = 0; i < 12; i++) {
            if (this.tabuleiro.getPosicaoLua() != i &&
                    null == this.tabuleiro.getPecas()[i]) {
                this.tabuleiro.getPecas()[i] = pegarPecaMonte();
            }
        }
    }

    private PecaDto pegarPecaMonte() {
        if (this.pecas.isEmpty()) {
            return null;
        }

        var peca = this.pecas.get(0);
        this.pecas.remove(0);
        return peca;
    }

    private PecaDto pegarPecaTabuleiro(int posicaoPeca) {
        var peca = this.tabuleiro.getPecas()[posicaoPeca];
        this.tabuleiro.getPecas()[posicaoPeca] = null;

        return peca;
    }

    private JogadorDto pegarJogador(CorJogadorEnum corJogador) {
        return this.jogadores.stream()
                .filter(jogadorFilter -> jogadorFilter.getCor().equals(corJogador))
                .findFirst()
                .orElseThrow(() -> new JogoException("Joga não localizado!"));
    }
}
