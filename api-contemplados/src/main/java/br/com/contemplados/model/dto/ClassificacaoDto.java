package br.com.contemplados.model.dto;

import br.com.contemplados.model.enumarations.EnumStatus;

import java.time.LocalDate;
import java.util.UUID;

public class ClassificacaoDto {

    private UUID id;

    private int quantidadeCriterio;

    private int pontuacaoTotal;

    private LocalDate dataSelecionada;

    private EnumStatus status;

    public ClassificacaoDto() {
    }

    public ClassificacaoDto(UUID id, int quantidadeCriteriosAtendidos, int pontos, EnumStatus status) {
        this.id = id;
        this.quantidadeCriterio = quantidadeCriteriosAtendidos;
        this.pontuacaoTotal = pontos;
        this.dataSelecionada = LocalDate.now();
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public int getQuantidadeCriterio() {
        return quantidadeCriterio;
    }

    public int getPontuacaoTotal() {
        return pontuacaoTotal;
    }

    public LocalDate getDataSelecionada() {
        return dataSelecionada;
    }

    public EnumStatus getStatus() {
        return status;
    }
}
