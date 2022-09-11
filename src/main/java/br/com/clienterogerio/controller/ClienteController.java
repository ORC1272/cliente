package br.com.clienterogerio.controller;

import br.com.clienterogerio.dto.request.ClienteRequest;
import br.com.clienterogerio.dto.response.ClienteResponse;
import br.com.clienterogerio.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteResponse> incluir ( @Valid @RequestBody ClienteRequest clienteRequest,
                                                     UriComponentsBuilder uriComponentsBuilder ) {
        ClienteResponse clienteResponse = clienteService.incluir(clienteRequest);
        URI uri = uriComponentsBuilder.path("/cliente/{id}").buildAndExpand(clienteResponse.getId()).toUri();
        return ResponseEntity.created(uri).body(clienteResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover ( @PathVariable UUID id ) {
        clienteService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> listagem () {
        return ResponseEntity.ok(clienteService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> buscarPorId ( @PathVariable UUID id ) {
        ClienteResponse clienteResponse = clienteService.buscarPorId(id);
        return ResponseEntity.ok(clienteResponse);
    }
}



