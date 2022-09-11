package br.com.clienterogerio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;


@Data
@Entity
public class Endereco {
    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    private String logradouro;
    private String numero;
    private String cep;
    private String complemento;
    private String cidade;
    private String estado;
}
