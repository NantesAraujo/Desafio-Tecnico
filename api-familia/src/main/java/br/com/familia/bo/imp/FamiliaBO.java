package br.com.familia.bo.imp;

import br.com.familia.bo.interfaces.IFamiliaBO;
import br.com.familia.domain.entity.Familia;
import br.com.familia.repository.FamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FamiliaBO implements IFamiliaBO {

    @Autowired
    private FamiliaRepository familiaRepository;

    @Override
    public List<Familia> cadastrarFamilias(List<Familia> familias) {
        return familiaRepository.saveAll(familias);
    }
}
