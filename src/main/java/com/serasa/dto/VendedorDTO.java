package com.serasa.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class VendedorDTO {
    
    private String nome;

    private LocalDateTime dataInclusao;

    private List<String> estados;
}
