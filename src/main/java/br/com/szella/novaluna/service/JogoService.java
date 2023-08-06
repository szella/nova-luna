package br.com.szella.novaluna.service;

import br.com.szella.novaluna.dto.JogadorDto;
import br.com.szella.novaluna.dto.TabuleiroDto;
import br.com.szella.novaluna.enums.CorJogadorEnum;

import java.util.List;

public interface JogoService {

    void inserirJogador(JogadorDto jogador);

    List<JogadorDto> todosJogadores();

    void iniciarPartida();

    void pegarPeca(CorJogadorEnum corJogador, int posicaoPeca, int posicaoX, int posicaoY);

    TabuleiroDto tabuleiro();
}
