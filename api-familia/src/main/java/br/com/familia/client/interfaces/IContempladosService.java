package br.com.familia.client.interfaces;

import br.com.familia.domain.entity.Familia;

import java.util.List;

public interface IContempladosService {

    String enviarFamiliasClassificadas(List<Familia> familias);
}
