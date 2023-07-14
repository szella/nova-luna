package br.com.szella.novaluna.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TabuleiroCasaDto {
    private List<JogadorDto> jogadores;
}
