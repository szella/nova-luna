package br.com.szella.novaluna.service.impl;

import br.com.szella.novaluna.dto.JogadorDto;
import br.com.szella.novaluna.mapper.JogadorMapper;
import br.com.szella.novaluna.request.JogadorRequest;
import br.com.szella.novaluna.response.JogadorResponse;
import br.com.szella.novaluna.service.JogoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JogoServiceImpl implements JogoService {

    private List<JogadorDto> jogadores = new ArrayList<JogadorDto>();

    @Override
    public List<JogadorResponse> inserirJogado(JogadorRequest jogador) {

        if (jogadores.stream().anyMatch(jogadorFilter -> jogadorFilter.getCor().equals(jogador.getCor()))) {
            jogadores = jogadores.stream()
                    .map(jogadorMap ->
                            jogadorMap.getCor().equals(jogador.getCor())
                                    ? JogadorMapper.mapDto(jogador) : jogadorMap)
                    .toList();
        } else {
            jogadores.add(JogadorMapper.mapDto(jogador));
        }

        return JogadorMapper.mapResponseList(jogadores);
    }
}
