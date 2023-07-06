package br.com.szella.novaluna.dto;

import lombok.Data;

import java.util.List;

@Data
public class TabuleiroDto {
    private Long id;
    private Integer posicaoLua;
    private List<TabuleiroCasaDto> casas;
    private List<PecaDto> pecas;
}
