package com.serasa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.serasa.dto.VendedorDTO;
import com.serasa.dto.VendedorListItemDTO;
import com.serasa.mappers.VendedorListItemMapper;
import com.serasa.mappers.VendedorMapper;
import com.serasa.model.Vendedor;
import com.serasa.repository.AtuacaoRepository;
import com.serasa.repository.VendedorRepository;
import com.serasa.service.VendedorService;

@ExtendWith(MockitoExtension.class)
public class VendedorServiceTest {

    @InjectMocks
    private VendedorService vendedorService;

    @Mock
    private VendedorListItemMapper vendedorListItemMapper;

    @Mock
    private VendedorMapper vendedorMapper;

    @Mock
    private VendedorRepository vendedorRepository;

    @Mock
    private AtuacaoRepository atuacaoRepository;

    private Vendedor vendedor;

    @BeforeEach
    void run() {
        vendedor = new Vendedor();
    }

    @Test
    public void testSalvar() {
        // ...

        // when
        when(vendedorRepository.save(vendedor)).thenReturn(vendedor);

        Vendedor vendedorSalvo = vendedorService.salvar(vendedor);
       

        // then
        assertNotNull(vendedorSalvo, "Falha - VendedorServiceTest - testSalvar()");
        // ...
    }

    @Test
    public void testListarTodos() {

        List<Vendedor> vendedores = new ArrayList<>();
        vendedores.add(vendedor);

        VendedorListItemDTO vendedorListItemDTO = new VendedorListItemDTO();
        List<VendedorListItemDTO> vendedoresDTO = new ArrayList<>();
        vendedoresDTO.add(vendedorListItemDTO);

        // when
        when(vendedorRepository.findAll()).thenReturn(vendedores);
        when(vendedorListItemMapper.toDto(vendedor)).thenReturn(vendedorListItemDTO);

        List<VendedorListItemDTO> vendedoresSalvosDTO = vendedorService.listarTodos();

        // then
        assertNotNull(vendedoresSalvosDTO, "Falha - VendedorServiceTest - testListaTodos() - Objeto Nulo");
        assertEquals(vendedoresDTO.size(), vendedoresSalvosDTO.size(), "Falha - VendedorServiceTest - testListaTodos() - SizeList");

    }

    @Test
    public void testBuscarPorId() {

        // given
        Long id = 1L;
        String nome = "test";
        vendedor.setId(id);
        vendedor.setNome(nome);

        VendedorDTO vendedorDTO = new VendedorDTO();
        vendedorDTO.setNome(nome);

        // when
        when(vendedorRepository.findById(id)).thenReturn(Optional.of(vendedor));
        when(vendedorMapper.toDto(vendedor)).thenReturn(vendedorDTO);

        VendedorDTO vendedorEncontrado = vendedorService.buscarPorId(id);

        // then
        assertNotNull(vendedorEncontrado, "Falha - VendedorServiceTest - testBuscarPorId() - Objeto Nulo");
        assertEquals(vendedorDTO.getNome(), vendedorEncontrado.getNome(), "Falha - VendedorServiceTest - testBuscarPorId() - SizeList");
    }

}