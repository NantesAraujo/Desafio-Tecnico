package br.com.contemplados.bo.regras.interfaces;

import br.com.contemplados.model.dto.ClassificacaoDto;

public interface IRegra {

    boolean executa(ClassificacaoDto classificacaoDto);

}
