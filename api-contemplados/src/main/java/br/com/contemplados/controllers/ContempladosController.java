package br.com.contemplados.controllers;

import br.com.contemplados.model.dto.ClassificacaoDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contemplados")
public class ContempladosController {

    @PostMapping
    public ResponseEntity<?> pinpong(@RequestBody List<ClassificacaoDto> classificacaoDtos){
        return ResponseEntity.ok("Recebeu as familias ");
    }
}
