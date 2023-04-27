package com.serasa.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.serasa.dto.VendedorListItemDTO;
import com.serasa.model.Vendedor;

@Mapper(componentModel = "spring")
public interface VendedorListItemMapper {
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "telefone", target = "telefone")
    @Mapping(source = "idade", target = "idade")
    @Mapping(source = "cidade", target = "cidade")
    @Mapping(source = "estado", target = "estado")
    VendedorListItemDTO toDto(Vendedor vendedor);
}