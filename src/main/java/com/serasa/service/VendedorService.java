package com.serasa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serasa.dto.VendedorDTO;
import com.serasa.dto.VendedoresDTO;
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

    public Vendedor salvar(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    public List<VendedoresDTO> listarTodos(){
        List<Vendedor> vendedores = vendedorRepository.findAll();
        List<VendedoresDTO> objDto = new ArrayList<>();
        for (Vendedor vendedor: vendedores){
            objDto.add(criarVendedoresDTO(vendedor));
        }
        return objDto;
    }
    
    private VendedoresDTO criarVendedoresDTO(Vendedor vendedor){
        Optional<Atuacao> atuacao = atuacaoRepository.findById(vendedor.getRegiao());
        VendedoresDTO objDto = new VendedoresDTO();
        objDto.setNome(vendedor.getNome());
        objDto.setTelefone(vendedor.getTelefone());
        objDto.setIdade(vendedor.getIdade());
        objDto.setCidade(vendedor.getCidade());
        objDto.setEstado(vendedor.getEstado());
        if(atuacao.isPresent()){
            objDto.setEstados(atuacao.get().getEstados());
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

    private VendedorDTO criarVendedorDTO(Vendedor vendedor){
        Optional<Atuacao> atuacao = atuacaoRepository.findById(vendedor.getRegiao());
        VendedorDTO objDto = new VendedorDTO();
        objDto.setNome(vendedor.getNome());
        objDto.setDataInclusao(vendedor.getDataInclusao());
        if(atuacao.isPresent()){
            objDto.setEstados(atuacao.get().getEstados());
        }
        return objDto;
    }
}