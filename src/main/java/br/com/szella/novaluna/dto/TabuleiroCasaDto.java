package br.com.szella.novaluna.dto;

import lombok.Data;

import java.util.List;

@Data
public class TabuleiroCasaDto {
    private Long id;
    private List<JogadorDto> jogadores;
}
