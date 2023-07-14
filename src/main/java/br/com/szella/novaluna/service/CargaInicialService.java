package br.com.szella.novaluna.service;

import br.com.szella.novaluna.dto.PecaDto;
import br.com.szella.novaluna.dto.TabuleiroCasaDto;

import java.util.List;

public interface CargaInicialService {
    List<PecaDto> iniciarPecas();

    TabuleiroCasaDto[] carregarCasa();
}
