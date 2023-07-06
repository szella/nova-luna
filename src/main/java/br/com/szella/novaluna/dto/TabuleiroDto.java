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
public class TabuleiroDto {
    private Long id;
    private Integer posicaoLua;
    private List<TabuleiroCasaDto> casas;
    private List<PecaDto> pecas;
}
