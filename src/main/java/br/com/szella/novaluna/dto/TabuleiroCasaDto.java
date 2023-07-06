package br.com.szella.novaluna.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TabuleiroCasaDto {
    private Long id;
    private List<JogadorDto> jogadores;
    private TabuleiroDto tabuleiro;
}
