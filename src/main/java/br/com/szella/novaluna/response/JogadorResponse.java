package br.com.szella.novaluna.response;

import br.com.szella.novaluna.enums.CorJogadorEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JogadorResponse {
    private String nome;
    private CorJogadorEnum cor;
}
