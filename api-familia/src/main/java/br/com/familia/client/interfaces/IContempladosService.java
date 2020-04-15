package br.com.familia.client.interfaces;

import br.com.familia.domain.entity.Familia;
import br.com.familia.domain.dto.ClassificacaoDto;

import java.util.List;
import java.util.UUID;

public interface IContempladosService {

    List<String> enviarFamiliasClassificadas(List<Familia> familias);
}
