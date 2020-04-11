package br.com.familia.domain.entity;

import br.com.familia.domain.enumerations.EnumTipo;
import br.com.familia.util.IdadeUtil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
public class Pessoa extends BaseEntity {

    @Column
    private String nome;

    @Column
    @Enumerated(EnumType.STRING)
    private EnumTipo tipo;

    @Column
    private LocalDate dataDeNascimento;

    public int idadeAtual(){
        return IdadeUtil.calularIdade(this.dataDeNascimento);
    }

    public String getNome() {
        return nome;
    }

    public EnumTipo getTipo() {
        return tipo;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }
}
