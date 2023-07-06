package br.com.szella.novaluna.dto;

import br.com.szella.novaluna.enums.CorJogadorEnum;
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
public class JogadorDto {
    private CorJogadorEnum cor;
    private String nome;
    private TabuleiroCasaDto tabuleiroCasa;
}
