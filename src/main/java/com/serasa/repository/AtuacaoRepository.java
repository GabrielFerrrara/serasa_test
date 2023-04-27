package com.serasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.serasa.model.Atuacao;

@Repository
public interface AtuacaoRepository extends JpaRepository<Atuacao, String> {
}