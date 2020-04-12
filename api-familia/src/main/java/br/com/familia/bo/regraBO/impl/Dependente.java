package br.com.familia.bo.regraBO.impl;

import br.com.familia.domain.entity.Familia;
import br.com.familia.domain.entity.Pessoa;
import br.com.familia.bo.regraBO.interfaces.IRegra;

import java.util.List;
import java.util.stream.Collectors;

public class Dependente implements IRegra {

    @Override
    public void executa(Familia familia) {
        List<Pessoa> dependentes = familia.DependentesFamiliar();
        List<Pessoa> dependentesMenoresIdade = filtrarDependentesMenoresIdade(dependentes);

        switch (dependentesMenoresIdade.size()){
            case 1:
                familia.adicionarPontuacao(2);
                break;
            case 2:
                familia.adicionarPontuacao(2);
                break;
            case 3:
                familia.adicionarPontuacao(3);
                break;
        }
    }

    private List<Pessoa> filtrarDependentesMenoresIdade(List<Pessoa> pessoas) {
        return pessoas.stream().filter(pessoa -> pessoa.idadeAtual() <= 18).collect(Collectors.toList());
    }
}
