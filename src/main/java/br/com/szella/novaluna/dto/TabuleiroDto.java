package br.com.szella.novaluna.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TabuleiroDto {
    private Integer posicaoLua;
    private Integer ultimaPosicao;
    private JogadorDto ultimojogador;
    private TabuleiroCasaDto[] casas;
    private PecaDto[] pecas;
}
