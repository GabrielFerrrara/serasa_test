package com.serasa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serasa.model.Atuacao;
import com.serasa.repository.AtuacaoRepository;

@Service
public class AtuacaoService {

    @Autowired
    private AtuacaoRepository AtuacaoRepository;

    public Atuacao salvar(Atuacao Atuacao) {
        return AtuacaoRepository.save(Atuacao);
    }

    public Optional<Atuacao> buscarPorId(String id) {
        return AtuacaoRepository.findById(id);
    }

}