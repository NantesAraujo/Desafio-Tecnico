package br.com.familia.client.impl;

import br.com.familia.client.interfaces.IContempladosService;
import br.com.familia.domain.entity.Familia;
import br.com.familia.dto.ClassificacaoDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContempladosService implements IContempladosService {

    private static final String url = "http://localhost:9127/contemplados-service/v1";

    @Override
    public String enviarFamiliasClassificadas(List<Familia> familias) {

        List<ClassificacaoDto> classificacaoDtos = new ArrayList<>();

        familias.forEach(familia -> classificacaoDtos.add(new ClassificacaoDto(familia)));

        String response = new RestTemplate().postForObject(url + "/contemplados", classificacaoDtos, String.class);
        return response;
    }
}
