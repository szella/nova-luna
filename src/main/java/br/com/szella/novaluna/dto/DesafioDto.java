package br.com.szella.novaluna.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class DesafioDto {
    private Integer amarelo;
    private Integer azul;
    private Integer verde;
    private Integer vermelho;
}
