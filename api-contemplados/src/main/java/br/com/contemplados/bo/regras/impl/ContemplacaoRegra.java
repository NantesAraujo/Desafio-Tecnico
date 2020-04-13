package br.com.contemplados.bo.regras.impl;

import br.com.contemplados.bo.regras.interfaces.IRegra;
import br.com.contemplados.model.dto.ClassificacaoDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ContemplacaoRegra {

    private List<IRegra> regras;

    List<ClassificacaoDto> classificacoesSelecionadas;

    public ContemplacaoRegra(List<IRegra> regras){
        this.regras = regras;
        classificacoesSelecionadas = new ArrayList<>();
    }

    public void classificiar(ClassificacaoDto classificacaoDto) {
        this.regras.forEach(regra -> {
            if(regra.executa(classificacaoDto))
                classificacoesSelecionadas.add(classificacaoDto);
        });
    }

    public List<ClassificacaoDto> getClassificacoesSelecionadas() {
        return classificacoesSelecionadas;
    }
}
