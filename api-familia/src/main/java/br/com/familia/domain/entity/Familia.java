package br.com.familia.domain.entity;

import br.com.familia.domain.enumerations.EnumTipo;
import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
public class Familia extends Pontuacao {

    @Column
    @OneToMany(cascade = CascadeType.ALL,  orphanRemoval = true)
    private List<Pessoa> pessoas;

    @Column
    @OneToMany(cascade = CascadeType.ALL,  orphanRemoval = true)
    private List<Renda> rendas;

    private String status;

    public long quantidadeDeDependentes(){
        return this.pessoas.stream().filter(pessoa -> EnumTipo.Dependente.equals(pessoa.getTipo())).collect(Collectors.toList()).size();
    }

    public Double rendaTotal(){
        Double totalRenda = 0.0;

        for (Renda renda: rendas)
            totalRenda += renda.getValor();

        return totalRenda;
    }
}
