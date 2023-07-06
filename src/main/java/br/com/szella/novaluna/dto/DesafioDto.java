package br.com.szella.novaluna.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DesafioDto {
    private Integer corAmarelo;
    private Integer corAzul;
    private Integer corVerde;
    private Integer corVermelho;
    private PecaDto peca;
}
