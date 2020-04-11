package br.com.familia.domain.entity;

import lombok.Getter;

import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass
public class Pontuacao extends BaseEntity {

    private int pontos;

    private int quantidadeCriteriosAtendidos;

    public void adicionarPontuacao(int pontos){
        this.pontos += pontos;
        this.quantidadeCriteriosAtendidos++;
    }

}
