package br.com.contemplados.controllers;

import br.com.contemplados.bo.comtenplatosBO.interfaces.IContempladoBO;
import br.com.contemplados.model.dto.ClassificacaoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class ContempladosController {

    @Autowired
    private IContempladoBO contempladoBO;

    @RequestMapping(value = "/contemplados", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<?> selecionarContemplados(@RequestBody List<ClassificacaoDto> classificacaoDtos){
        try {
            List<String> idsFamiliasContempladas = contempladoBO.classifica(classificacaoDtos);
            return ResponseEntity.ok().body(idsFamiliasContempladas);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possível filtrar familias aptas ao benefício.");
        }
    }
}
