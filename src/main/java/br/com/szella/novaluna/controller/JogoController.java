package br.com.szella.novaluna.controller;

import br.com.szella.novaluna.request.JogadorRequest;
import br.com.szella.novaluna.response.JogadorResponse;
import br.com.szella.novaluna.service.JogoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("iniciar-jogador")
    public ResponseEntity<List<JogadorResponse>> inserirJogado(@RequestBody JogadorRequest jogador) {
        var jogadores = jogoService.inserirJogado(jogador);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(jogadores);
    }

}
