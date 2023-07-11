package br.com.szella.novaluna.service.impl;

import br.com.szella.novaluna.dto.JogadorDto;
import br.com.szella.novaluna.exception.JogoException;
import br.com.szella.novaluna.mapper.JogadorMapper;
import br.com.szella.novaluna.request.JogadorRequest;
import br.com.szella.novaluna.response.JogadorResponse;
import br.com.szella.novaluna.service.JogoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JogoServiceImpl implements JogoService {

    private List<JogadorDto> jogadores = new ArrayList<JogadorDto>();
    private Boolean jogoIniciado = false;

    @Override
    public void inserirJogador(JogadorRequest jogador) {

        if (jogoIniciado) {
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

        jogoIniciado=true;
    }
}
