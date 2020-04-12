package br.com.contemplados.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contemplados")
public class ContempladosController {

    @PostMapping
    public ResponseEntity<?> pinpong(@RequestBody String conteudoRecebido){
        return ResponseEntity.ok("Recebeu: " + conteudoRecebido);
    }
}
