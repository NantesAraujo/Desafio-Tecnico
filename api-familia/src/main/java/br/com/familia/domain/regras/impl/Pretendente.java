package br.com.familia.domain.regras.impl;

import br.com.familia.domain.entity.Familia;
import br.com.familia.domain.entity.Pessoa;
import br.com.familia.domain.enumerations.EnumNivel;
import br.com.familia.domain.regras.interfaces.IRegra;
import br.com.familia.util.IdadeUtil;

public class Pretendente implements IRegra {

    private int idade;

    @Override
    public void executa(Familia familia) {
        Pessoa pretendenteFamilia = familia.buscarPretendenteFamiliar();

        this.idade = IdadeUtil.calularIdade(pretendenteFamilia.getDataDeNascimento());

        EnumNivel idadeClassificada = avaliarIdade();

        switch (idadeClassificada){
            case BAIXA:
                familia.adicionarPontuacao(1);
                break;
            case MEDIA:
                familia.adicionarPontuacao(2);
                break;
            case ALTA:
                familia.adicionarPontuacao(3);
                break;
            default:
                break;
        }
    }

    private EnumNivel avaliarIdade(){
        if(isIdadeMenorTrintaAnos())
             return EnumNivel.BAIXA;
        else if (isIdadeEntreTrintaAQuarentaQuatroAnos())
            return EnumNivel.MEDIA;
        else if(isIdadeMaiorQuarentaCincoAnos())
            return EnumNivel.ALTA;

        return null;
    }

    private boolean isIdadeMenorTrintaAnos(){
        return this.idade < 30;
    }

    private boolean isIdadeEntreTrintaAQuarentaQuatroAnos(){
        return this.idade >= 30 && idade <= 44;
    }

    private boolean isIdadeMaiorQuarentaCincoAnos(){
        return this.idade >= 30 && idade <= 44;
    }
}
