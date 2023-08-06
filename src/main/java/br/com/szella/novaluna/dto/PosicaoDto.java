package br.com.szella.novaluna.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PosicaoDto {
    private int x;
    private int y;
}
