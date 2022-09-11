package br.com.clienterogerio.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column(nullable = false, length = 200)
    private String nome;

    @Column(nullable = false, length = 200)
    private String sobrenome;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false)
    private int idade;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ENDERECO_ID")
    private Endereco endereco;
}
