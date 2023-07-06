package br.com.szella.novaluna.request;

import br.com.szella.novaluna.enums.CorJogadorEnum;
import lombok.Data;

@Data
public class JogadorRequest {
    private String nome;
    private CorJogadorEnum cor;
}
