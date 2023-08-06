package br.com.szella.novaluna.mapper;

import br.com.szella.novaluna.dto.JogadorDto;
import br.com.szella.novaluna.request.JogadorRequest;
import br.com.szella.novaluna.response.JogadorResponse;
import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.List;

@UtilityClass
public class JogadorMapper {

    public JogadorDto mapDto(JogadorRequest jogador) {
        return JogadorDto.builder()
                .nome(jogador.getNome())
                .cor(jogador.getCor())
                .casa(0)
                .pecas(new HashMap<>())
                .build();
    }

    public JogadorResponse mapResponse(JogadorDto jogador) {
        return JogadorResponse.builder()
                .nome(jogador.getNome())
                .cor(jogador.getCor())
                .build();
    }

    public List<JogadorResponse> mapResponseList(List<JogadorDto> listaJogador) {
        return listaJogador
                .stream()
                .map(JogadorMapper::mapResponse)
                .toList();
    }
}
