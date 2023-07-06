package br.com.szella.novaluna.dto;

import br.com.szella.novaluna.enums.CorPecaEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PecaDto {
    private Integer passos;
    private CorPecaEnum cor;
    private List<DesafioDto> desafios;
    private TabuleiroDto tabuleiro;
}
