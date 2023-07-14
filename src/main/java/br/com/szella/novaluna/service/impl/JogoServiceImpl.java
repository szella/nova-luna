package br.com.szella.novaluna.service.impl;

import br.com.szella.novaluna.dto.JogadorDto;
import br.com.szella.novaluna.dto.PecaDto;
import br.com.szella.novaluna.dto.TabuleiroDto;
import br.com.szella.novaluna.exception.JogoException;
import br.com.szella.novaluna.mapper.JogadorMapper;
import br.com.szella.novaluna.request.JogadorRequest;
import br.com.szella.novaluna.response.JogadorResponse;
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
    public void inserirJogador(JogadorRequest jogador) {

        if (null != this.tabuleiro) {
            throw new JogoException("Partida iniciada!");
        }

        if (jogadores.stream().anyMatch(jogadorFilter -> jogadorFilter.getCor().equals(jogador.getCor()))) {
            jogadores = jogadores.stream()
                    .map(jogadorMap ->
                            jogadorMap.getCor().equals(jogador.getCor())
                                    ? JogadorMapper.mapDto(jogador) : jogadorMap)
                    .collect(Collectors.toList());
        } else {
            jogadores.add(JogadorMapper.mapDto(jogador));
        }
    }

    @Override
    public List<JogadorResponse> todosJogadores() {
        return JogadorMapper.mapResponseList(jogadores);
    }

    @Override
    public void iniciarPartida() {
        if (jogadores.size() == 0) {
            throw new JogoException("Registre um jogador!");
        }

        Collections.shuffle(jogadores);
        iniciarTabuleiro();

        System.out.println("ok");
    }

    public void iniciarTabuleiro() {
        if (null != this.tabuleiro) {
            throw new JogoException("Joga já foi iniciado!");
        }

        this.pecas = cargaInicialService.iniciarPecas();
        this.tabuleiro = TabuleiroDto.builder()
                .posicaoLua(0)
                .ultimaPosicao(0)
                .pecas(new PecaDto[12])
                .casas(cargaInicialService.carregarCasa())
                .build();

        this.tabuleiro.getCasas()[0].setJogadores(jogadores);

        carregarPecasTabuleiro();
    }

    private void carregarPecasTabuleiro() {
        for (int i = 0; i < 12; i++) {
            if (null == this.tabuleiro.getPecas()[i]) {
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
}
