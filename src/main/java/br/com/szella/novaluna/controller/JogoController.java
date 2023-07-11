package br.com.szella.novaluna.controller;

import br.com.szella.novaluna.request.JogadorRequest;
import br.com.szella.novaluna.response.JogadorResponse;
import br.com.szella.novaluna.service.JogoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jogo")
@RequiredArgsConstructor
public class JogoController {

    private final JogoService jogoService;

    @GetMapping("/jogadores")
    public ResponseEntity<List<JogadorResponse>> todosJogadores() {
        var jogadores = jogoService.todosJogadores();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(jogadores);
    }

    @PostMapping("/iniciar-jogador")
    public ResponseEntity<Void> inserirJogado(@RequestBody JogadorRequest jogador) {
        jogoService.inserirJogador(jogador);

        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @GetMapping("/iniciar-partida")
    public ResponseEntity<String> iniciarPartida() {
        jogoService.iniciarPartida();
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

}
