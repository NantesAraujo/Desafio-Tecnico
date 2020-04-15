package br.com.contemplados.bo.regras.impl;

import br.com.contemplados.bo.regras.interfaces.IRegra;
import br.com.contemplados.model.dto.ClassificacaoDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class ContemplacaoRegra {

    private List<IRegra> regras;

    List<String> idsFamiliasSelecionadas;

    public ContemplacaoRegra(List<IRegra> regras){
        this.regras = regras;
        idsFamiliasSelecionadas = new ArrayList<>();
    }

    public void classificiar(ClassificacaoDto classificacaoDto) {
        this.regras.forEach(regra -> {
            if(regra.executa(classificacaoDto))
                idsFamiliasSelecionadas.add(classificacaoDto.getId().toString());
        });
    }

    public List<String> getIdsFamiliasSelecionadas() {
        return idsFamiliasSelecionadas;
    }
}
