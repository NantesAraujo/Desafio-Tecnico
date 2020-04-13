package br.com.familia.client.interfaces;

import br.com.familia.domain.entity.Familia;
import br.com.familia.dto.ClassificacaoDto;

import java.util.List;

public interface IContempladosService {

    ClassificacaoDto[] enviarFamiliasClassificadas(List<Familia> familias);
}
