package br.com.contemplados.bo.comtenplatosBO.impl;

import br.com.contemplados.bo.comtenplatosBO.interfaces.IContempladoBO;
import br.com.contemplados.bo.regras.impl.ContemplacaoRegra;
import br.com.contemplados.bo.regras.impl.SituacaoCadastral;
import br.com.contemplados.bo.regras.interfaces.IRegra;
import br.com.contemplados.model.dto.ClassificacaoDto;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ContempladoBO implements IContempladoBO {

    @Override
    public List<ClassificacaoDto> classifica(List<ClassificacaoDto> classificacaoDtoList) {
        List<IRegra> regas = Arrays.asList(new SituacaoCadastral());

        ContemplacaoRegra contemplacaoRegra = new ContemplacaoRegra(regas);

        classificacaoDtoList.forEach(classificacaoDto -> {
            contemplacaoRegra.classificiar(classificacaoDto);
        });

        return contemplacaoRegra.getClassificacoesSelecionadas();
    }
}
