package br.com.familia.controllers;

import br.com.familia.bo.familiaBO.interfaces.IFamiliaBO;
import br.com.familia.client.interfaces.IContempladosService;
import br.com.familia.domain.entity.Familia;
import br.com.familia.domain.dto.ClassificacaoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/familia")
public class FamiliaController {

    @Autowired
    private IFamiliaBO familiaBO;

    @Autowired
    private IContempladosService contempladosService;

    @PostMapping
    public ResponseEntity<?> cadastrarfamilias(@RequestBody List<Familia> familias){
        try {
            List<Familia> familiaList = familiaBO.cadastrarFamilias(familias);

            List<String> idsFamiliasContempladas = contempladosService.enviarFamiliasClassificadas(familiaList);

            List<Familia> listagemFimiliasSelecionadas = familiaBO.removerFamiliasNaoContempladas(familiaList, idsFamiliasContempladas);

            return ResponseEntity.ok(listagemFimiliasSelecionadas);
        } catch (Exception e){
            System.out.println(e);
            return ResponseEntity.badRequest().body("Não foi possível cadastrar as familias");
        }
    }
}
