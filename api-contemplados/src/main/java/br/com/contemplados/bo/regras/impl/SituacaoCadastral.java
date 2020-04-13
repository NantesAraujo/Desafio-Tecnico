package br.com.contemplados.bo.regras.impl;

import br.com.contemplados.bo.regras.interfaces.IRegra;
import br.com.contemplados.model.dto.ClassificacaoDto;

public class SituacaoCadastral implements IRegra {

    @Override
    public boolean executa(ClassificacaoDto classificacaoDto) {
        switch (classificacaoDto.getStatus()){
            case CADASTRO_VALIDO:
                return true;
            case JA_POSSUI_CASA: case SELECIONADA_OUTRO_PROCESSO: case CADASTRO_INCOMPLETO: default:
                return false;
        }
    }
}
