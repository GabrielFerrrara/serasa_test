package com.serasa.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serasa.dto.VendedorDTO;
import com.serasa.dto.VendedorListItemDTO;
import com.serasa.mappers.VendedorListItemMapper;
import com.serasa.mappers.VendedorMapper;
import com.serasa.model.Atuacao;
import com.serasa.model.Vendedor;
import com.serasa.repository.AtuacaoRepository;
import com.serasa.repository.VendedorRepository;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private AtuacaoRepository atuacaoRepository;

    @Autowired
    private VendedorListItemMapper vendedorListItemMapper;

    @Autowired
    private VendedorMapper vendedorMapper;

    public Vendedor salvar(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    public List<VendedorListItemDTO> listarTodos(){
        List<Vendedor> vendedores = vendedorRepository.findAll();
        List<VendedorListItemDTO> objDto = new ArrayList<>();
        for (Vendedor vendedor: vendedores){
            objDto.add(criarVendedoresDTO(vendedor));
        }
        return objDto;
    }

    public VendedorDTO buscarPorId(Long id) {
        Optional<Vendedor> vendedor = vendedorRepository.findById(id);
        if(vendedor.isPresent()){
            return criarVendedorDTO(vendedor.get());
        } else {
            return null;
        }
    }
    
    private VendedorListItemDTO criarVendedoresDTO(Vendedor vendedor){
        VendedorListItemDTO objDto = vendedorListItemMapper.toDto(vendedor);
        objDto.setEstados(getEstados(vendedor.getRegiao()));

        return objDto;
    }


    private VendedorDTO criarVendedorDTO(Vendedor vendedor){
        VendedorDTO objDto = vendedorMapper.toDto(vendedor);
        objDto.setEstados(getEstados(vendedor.getRegiao()));
        return objDto;
    }

    private List<String> getEstados(String regiao){
        Optional<Atuacao> atuacao = atuacaoRepository.findById(regiao);
        if(atuacao.isPresent()){
            return atuacao.get().getEstados();
        }
        return Collections.emptyList();
    }
}