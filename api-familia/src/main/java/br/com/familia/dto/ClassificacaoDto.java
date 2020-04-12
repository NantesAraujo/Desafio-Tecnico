package br.com.familia.dto;

import br.com.familia.domain.entity.Familia;
import br.com.familia.domain.enumerations.EnumStatus;

import java.time.LocalDate;
import java.util.UUID;

public class ClassificacaoDto {

    private UUID id;

    private int quantidadeCriterio;

    private int pontuacaoTotal;

    private LocalDate dataSelecionada;

    private EnumStatus status;

    public ClassificacaoDto(Familia familia) {
        this.id = familia.getId();
        this.quantidadeCriterio = familia.getQuantidadeCriteriosAtendidos();
        this.pontuacaoTotal = familia.getPontos();
        this.dataSelecionada = LocalDate.now();
        this.status = familia.getStatus();
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
