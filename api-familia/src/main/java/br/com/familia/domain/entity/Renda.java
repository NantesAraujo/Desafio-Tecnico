package br.com.familia.domain.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Renda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private String pessoaId;

    @Column
    private Double valor;

    public String getPessoaId() {
        return pessoaId;
    }

    public Double getValor() {
        return valor;
    }
}
