package com.serasa.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.serasa.model.Atuacao;
import com.serasa.service.AtuacaoService;

@RestController
@RequestMapping("/atuacao")
public class AtuacaoController {

    @Autowired
    private AtuacaoService AtuacaoService;

    @PostMapping
    public ResponseEntity<Atuacao> salvar(@RequestBody Atuacao Atuacao) {
        AtuacaoService.salvar(Atuacao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}