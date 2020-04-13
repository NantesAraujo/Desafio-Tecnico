package br.com.contemplados.bo.comtenplatosBO.interfaces;

import br.com.contemplados.model.dto.ClassificacaoDto;

import java.util.List;

public interface IContempladoBO {

    List<ClassificacaoDto> classifica(List<ClassificacaoDto> classificacaoDtoList);
}
