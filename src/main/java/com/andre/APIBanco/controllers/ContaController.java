package com.andre.APIBanco.controllers;

import com.andre.APIBanco.models.Conta;
import com.andre.APIBanco.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContaController {
    @Autowired
    ContaService contaService;

    @GetMapping("/contas")
    public ResponseEntity<List<Conta>> buscarTodas() {
        return ResponseEntity.ok(contaService.buscarTodas());
    }

    @GetMapping("/contas/{id}")
    public ResponseEntity<Conta> buscarPorId(@PathVariable("id") long id) {
        Conta conta = contaService.buscarPorId(id);
        if(conta == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(conta);
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criar(@RequestBody Conta conta) {
        return ResponseEntity.ok(contaService.criar(conta));
    }

    @PutMapping("/atualizar/{senha}")
    public ResponseEntity<String> atualizar(@RequestBody Conta conta, @PathVariable("senha") String senha) {
        return ResponseEntity.ok(contaService.atualizar(conta, senha));
    }

    @DeleteMapping("/deletar/{id}/{senha}")
    public ResponseEntity<String> deletar(@PathVariable("id") long id, @PathVariable("senha") String senha) {
        return ResponseEntity.ok(contaService.deletar(id, senha));
    }
}
