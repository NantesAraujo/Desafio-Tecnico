package br.com.contemplados.bo.comtenplatosBO.interfaces;

import br.com.contemplados.model.dto.ClassificacaoDto;

import java.util.List;
import java.util.UUID;

public interface IContempladoBO {

    List<String> classifica(List<ClassificacaoDto> classificacaoDtoList);
}
