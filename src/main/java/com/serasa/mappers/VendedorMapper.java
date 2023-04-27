package com.serasa.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.serasa.dto.VendedorDTO;
import com.serasa.model.Vendedor;

@Mapper(componentModel = "spring")
public interface VendedorMapper {
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "dataInclusao", target = "dataInclusao")
    VendedorDTO toDto(Vendedor vendedor);
}
