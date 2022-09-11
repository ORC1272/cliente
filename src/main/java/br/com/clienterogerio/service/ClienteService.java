package br.com.clienterogerio.service;

import br.com.clienterogerio.dto.request.ClienteRequest;
import br.com.clienterogerio.dto.response.ClienteResponse;
import br.com.clienterogerio.exception.ItemNaoExistenteException;
import br.com.clienterogerio.mapper.ClienteMapper;
import br.com.clienterogerio.model.Cliente;
import br.com.clienterogerio.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteMapper mapper;
    private final ClienteRepository repository;

    public ClienteResponse incluir (ClienteRequest clienteRequest){
        Cliente cliente = mapper.toModel(clienteRequest);
        return mapper.toResponse(repository.save(cliente));
    }


    public List<ClienteResponse> listar() {
        return mapper.toResponseList(repository.findAll());
    }

    public ClienteResponse buscarPorId(UUID id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(ItemNaoExistenteException::new);
        return mapper.toResponse(cliente);
    }


    public void remover(UUID id) {
        repository.deleteById(id);
    }
}

