package br.com.clienterogerio.mapper;

import br.com.clienterogerio.dto.request.ClienteRequest;
import br.com.clienterogerio.dto.response.ClienteResponse;
import br.com.clienterogerio.model.Cliente;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteResponse toResponse( Cliente cliente);
    Cliente toModel( ClienteRequest clienteRequest);
    List<ClienteResponse> toResponseList( List<Cliente>clientes);

//    @InheritInverseConfiguration
//    ClienteResponse campoToResponse(Cliente cliente);

}
