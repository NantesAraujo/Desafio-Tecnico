package br.com.familia.controllers;

import br.com.familia.bo.interfaces.IFamiliaBO;
import br.com.familia.domain.entity.Familia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/familia")
public class FamiliaController {

    @Autowired
    private IFamiliaBO familiaBO;

    @PostMapping
    public ResponseEntity<?> cadastrarfamilias(@RequestBody List<Familia> familias){
        try {
            List<Familia> familiaList = familiaBO.cadastrarFamilias(familias);

            Collections.sort(familiaList);

            return ResponseEntity.ok(familiaList);
        } catch (Exception e){
            System.out.println(e);
            return ResponseEntity.badRequest().body("Não foi possível cadastrar as familias");
        }
    }

}
