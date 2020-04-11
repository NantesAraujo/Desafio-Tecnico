package br.com.familia.bo.interfaces;

import br.com.familia.domain.entity.Familia;

import java.util.List;

public interface IFamiliaBO {

    List<Familia> cadastrarFamilias(List<Familia> familias);
}
