package br.com.szella.novaluna.dto;

import br.com.szella.novaluna.enums.CorPecaEnum;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PecaDto {
    private Integer passos;
    private CorPecaEnum cor;
    private List<DesafioDto> desafios;
}
