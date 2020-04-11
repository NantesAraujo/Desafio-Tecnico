package br.com.familia.domain.regras.impl;

import br.com.familia.domain.entity.Familia;
import br.com.familia.domain.regras.interfaces.IRegra;

import java.util.List;

public class ClassificadorFamiliar {

    private List<IRegra> regras;

    public ClassificadorFamiliar(List<IRegra> regras){
        this.regras = regras;
    }

    public void classifica(Familia familia){
        regras.forEach(regra -> {
            regra.executa(familia);
        });
    }
}
