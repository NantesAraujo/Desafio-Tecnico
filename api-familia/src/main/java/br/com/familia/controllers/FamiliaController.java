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

import java.util.List;

@RestController
@RequestMapping("/familia")
public class FamiliaController {

    @Autowired
    private IFamiliaBO familiaBO;

    @PostMapping
    public ResponseEntity<?> cadastrarfamilias(@RequestBody List<Familia> familias){
        try {
            return ResponseEntity.ok(familiaBO.cadastrarFamilias(familias));
        } catch (Exception e){
            System.out.println(e);
            return ResponseEntity.badRequest().body("Não foi possível cadastrar as familias");
        }
    }

}
