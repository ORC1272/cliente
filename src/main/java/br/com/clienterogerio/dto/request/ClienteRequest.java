package br.com.clienterogerio.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClienteRequest {
    @NotNull(message = "O nome não pode ser vazio")
    @Min(value = 3, message = "O nome deve ter no mínimo 3 caracteres")
    private String nome;

    @NotNull(message = "O sobrenome não pode ser vazio")
    @Max(value = 200, message = "O sobrenome deve ter no maximo 200 caracteres")
    private String sobrenome;

    @NotNull(message = "O cpf não pode ser vazio")
    @Max(value = 11, message = "O nome deve ter no maximo 11 caracteres")
    private String cpf;

    @NotNull(message = "O campo idade não pode ser vazio")
    private int idade;

    @NotNull
    private EnderecoRequest endereco;
}
