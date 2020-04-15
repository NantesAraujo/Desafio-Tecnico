package br.com.familia.bo.familiaBO.interfaces;

import br.com.familia.domain.entity.Familia;

import java.util.List;
import java.util.UUID;

public interface IFamiliaBO {

    List<Familia> cadastrarFamilias(List<Familia> familias);

    List<Familia> removerFamiliasNaoContempladas(List<Familia> familiaList, List<String> idsFamiliasContempladas);
}
