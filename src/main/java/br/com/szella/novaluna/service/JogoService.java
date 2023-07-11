package br.com.szella.novaluna.service;

import br.com.szella.novaluna.request.JogadorRequest;
import br.com.szella.novaluna.response.JogadorResponse;

import java.util.List;

public interface JogoService {

    void inserirJogador(JogadorRequest jogador);

    List<JogadorResponse> todosJogadores();

    void iniciarPartida();
}
