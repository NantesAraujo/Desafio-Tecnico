package br.com.familia.domain.entity;

import lombok.Getter;

import javax.persistence.MappedSuperclass;

@Getter
@MappedSuperclass
public class Pontuacao extends BaseEntity {

    private Long pontos;

    private Long quantidadeCriteriosAtendidos;

}
