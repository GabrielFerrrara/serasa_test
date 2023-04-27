package com.serasa.mappers;

import com.serasa.dto.VendedorDTO;
import com.serasa.model.Vendedor;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-27T18:30:11-0300",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20230218-1114, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class VendedorMapperImpl implements VendedorMapper {

    @Override
    public VendedorDTO toDto(Vendedor vendedor) {
        if ( vendedor == null ) {
            return null;
        }

        VendedorDTO vendedorDTO = new VendedorDTO();

        vendedorDTO.setNome( vendedor.getNome() );
        vendedorDTO.setDataInclusao( vendedor.getDataInclusao() );

        return vendedorDTO;
    }
}
