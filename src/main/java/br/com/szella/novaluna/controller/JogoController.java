package br.com.szella.novaluna.controller;

import br.com.szella.novaluna.dto.TabuleiroDto;
import br.com.szella.novaluna.enums.CorJogadorEnum;
import br.com.szella.novaluna.mapper.JogadorMapper;
import br.com.szella.novaluna.request.JogadorRequest;
import br.com.szella.novaluna.response.JogadorResponse;
import br.com.szella.novaluna.service.JogoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jogo")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200/"})
public class JogoController {

    private final JogoService jogoService;

    @GetMapping("/jogadores")
    public ResponseEntity<List<JogadorResponse>> todosJogadores() {
        var jogadores = jogoService.todosJogadores();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(JogadorMapper.mapResponseList(jogadores));
    }

    @GetMapping("/tabuleiro")
    public ResponseEntity<TabuleiroDto> tabuleiro(){
        var tabuleiro = this.jogoService.tabuleiro();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tabuleiro);
    }

    @PostMapping("/iniciar-jogador")
    public ResponseEntity<Void> inserirJogado(@RequestBody JogadorRequest jogador) {
        jogoService.inserirJogador(JogadorMapper.mapDto(jogador));

        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @GetMapping("/iniciar-partida")
    public ResponseEntity<Void> iniciarPartida() {
        jogoService.iniciarPartida();
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @GetMapping("/pegar-peca/{corJogador}/{posicaoPeca}/{posicaoX}/{posicaoY}")
    public ResponseEntity<Void> pegarPeca(
            @PathVariable CorJogadorEnum corJogador,
            @PathVariable int posicaoPeca,
            @PathVariable int posicaoX,
            @PathVariable int posicaoY) {
        jogoService.pegarPeca(corJogador, posicaoPeca, posicaoX, posicaoY);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
