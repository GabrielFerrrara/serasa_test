package com.serasa.mappers;

import com.serasa.dto.VendedorListItemDTO;
import com.serasa.model.Vendedor;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-27T18:30:11-0300",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230218-1114, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class VendedorListItemMapperImpl implements VendedorListItemMapper {

    @Override
    public VendedorListItemDTO toDto(Vendedor vendedor) {
        if ( vendedor == null ) {
            return null;
        }

        VendedorListItemDTO vendedorListItemDTO = new VendedorListItemDTO();

        vendedorListItemDTO.setNome( vendedor.getNome() );
        vendedorListItemDTO.setTelefone( vendedor.getTelefone() );
        vendedorListItemDTO.setIdade( vendedor.getIdade() );
        vendedorListItemDTO.setCidade( vendedor.getCidade() );
        vendedorListItemDTO.setEstado( vendedor.getEstado() );

        return vendedorListItemDTO;
    }
}
