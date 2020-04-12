package br.com.familia.domain.entity;

import br.com.familia.domain.enumerations.EnumStatus;
import br.com.familia.domain.enumerations.EnumTipo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Familia extends Pontuacao implements Comparable<Familia> {

    @Column
    @OneToMany(cascade = CascadeType.ALL,  orphanRemoval = true)
    private List<Pessoa> pessoas;

    @Column
    @OneToMany(cascade = CascadeType.ALL,  orphanRemoval = true)
    private List<Renda> rendas;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private EnumStatus status;

    public Pessoa buscarPretendenteFamiliar(){
        return pessoas.stream().filter(pessoa -> EnumTipo.Pretendente.equals(pessoa.getTipo())).findFirst().get();
    }

    public List<Pessoa> DependentesFamiliar(){
        return this.pessoas.stream().filter(pessoa -> EnumTipo.Dependente.equals(pessoa.getTipo())).collect(Collectors.toList());
    }

    public Double rendaTotal(){
        Double totalRenda = 0.0;

        for (Renda renda: rendas)
            totalRenda += renda.getValor();

        return totalRenda;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public List<Renda> getRendas() {
        return rendas;
    }

    public EnumStatus getStatus() {
        return status;
    }

    @Override
    public int compareTo(Familia familia) {
        int valor = 0;

        if(this.getPontos() < familia.getPontos())
            valor = 1;
        else if(this.getPontos() == familia.getPontos())
            valor = 0;
        else if(this.getPontos() > familia.getPontos())
            valor = -1;

        return valor;
    }
}
