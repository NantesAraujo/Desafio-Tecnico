package br.com.familia.bo.regraBO.impl;

import br.com.familia.domain.entity.Familia;
import br.com.familia.domain.enumerations.EnumNivel;
import br.com.familia.bo.regraBO.interfaces.IRegra;

public class RendaFamiliar implements IRegra {

    @Override
    public void executa(Familia familia) {
        EnumNivel rendaClassificada = avaliarRenda(familia.rendaTotal());

        switch (rendaClassificada){
            case BAIXA:
                familia.adicionarPontuacao(5);
                break;
            case MEDIA:
                familia.adicionarPontuacao(3);
                break;
            case ALTA:
                familia.adicionarPontuacao(1);
                break;
            default:
                break;
        }
    }

    private EnumNivel avaliarRenda(Double rendaFamiliar){
        if(isRendaTotalAteNovecentosReais(rendaFamiliar))
            return EnumNivel.BAIXA;
        else if(isRendaEntreNovecentosEMilQuinhentosReais(rendaFamiliar))
            return EnumNivel.MEDIA;
        else if(isRendaEntreMilQuinhentosReaisEDoisMilReais(rendaFamiliar))
            return EnumNivel.ALTA;

        return null;
    }

    private boolean isRendaTotalAteNovecentosReais(Double renda){
        return renda <= 900;
    }

    private boolean isRendaEntreNovecentosEMilQuinhentosReais(Double renda){
        return renda >= 901 && renda <= 1500;
    }

    private boolean isRendaEntreMilQuinhentosReaisEDoisMilReais(Double renda){
        return renda >= 1501 && renda <= 2000;
    }
}
