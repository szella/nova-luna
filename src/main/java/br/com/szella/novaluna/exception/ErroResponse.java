package br.com.szella.novaluna.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErroResponse {
    private String mensagem;
}
