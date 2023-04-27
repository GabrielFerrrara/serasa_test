package com.serasa.dto;

import java.util.List;

import lombok.Data;

@Data
public class VendedoresDTO {
    
    private String nome;

    private String telefone;

    private Integer idade;

    private String cidade;

    private String estado;

    private List<String> estados;

}
