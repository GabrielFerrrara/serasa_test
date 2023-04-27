package com.serasa;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.serasa.model.Atuacao;
import com.serasa.repository.AtuacaoRepository;
import com.serasa.service.AtuacaoService;

@ExtendWith(MockitoExtension.class)
public class AtuacaoServiceTest {

    @InjectMocks
    private AtuacaoService atuacaoService;

    @Mock
    private AtuacaoRepository atuacaoRepository;

    private Atuacao atuacao;

    @BeforeEach
    void run() {
        atuacao = new Atuacao(); 
    }

    @Test
    public void testSalvar(){
        //when
        when(atuacaoRepository.save(atuacao)).thenReturn(atuacao);
        Atuacao atuacaoSalva = atuacaoService.salvar(atuacao);

        //then
        assertNotNull(atuacaoSalva, "Falha - AtuacaoServiceTest - testSalvar()");
    }

    @Test
    public void testBuscarPorId(){
        // given
        String regiao = "teste";
        atuacao.setRegiao(regiao);

        // when
        when(atuacaoRepository.findById(regiao)).thenReturn(Optional.of(atuacao));
        Optional<Atuacao> atuacaoEncontrada = atuacaoService.buscarPorId(regiao);

        // then
        assertNotNull(atuacaoEncontrada, "Falha - AtuacaoServiceTest - testBuscarPorId");
    }

}
