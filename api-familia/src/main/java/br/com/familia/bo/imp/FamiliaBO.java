package br.com.familia.bo.imp;

import br.com.familia.bo.interfaces.IFamiliaBO;
import br.com.familia.domain.entity.Familia;
import br.com.familia.domain.regras.impl.ClassificadorFamiliar;
import br.com.familia.domain.regras.impl.Dependente;
import br.com.familia.domain.regras.impl.Pretendente;
import br.com.familia.domain.regras.impl.RendaFamiliar;
import br.com.familia.domain.regras.interfaces.IRegra;
import br.com.familia.repository.FamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class FamiliaBO implements IFamiliaBO {

    @Autowired
    private FamiliaRepository familiaRepository;

    @Override
    public List<Familia> cadastrarFamilias(List<Familia> familias) {
        List<IRegra> listaRegras = Arrays.asList(new Dependente(), new Pretendente(), new RendaFamiliar());

        ClassificadorFamiliar classificadorFamiliar = new ClassificadorFamiliar(listaRegras);

        familias.forEach(familia -> {
            classificadorFamiliar.classifica(familia);
        });

        return familiaRepository.saveAll(familias);
    }
}
