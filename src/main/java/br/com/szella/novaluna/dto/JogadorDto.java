package br.com.szella.novaluna.dto;

import br.com.szella.novaluna.enums.CorJogadorEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JogadorDto {
    private CorJogadorEnum cor;
    private String nome;
}
