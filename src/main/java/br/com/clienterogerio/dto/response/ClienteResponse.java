package br.com.clienterogerio.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ClienteResponse {
    private UUID id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private int idade;
//    private String logradouro;
//    private Long numero;
//    private String cep;
//    private String complemento;
//    private String cidade;
//    private String estado;
}
