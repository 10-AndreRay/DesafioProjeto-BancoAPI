package com.andre.APIBanco.controllers;

import com.andre.APIBanco.models.SacarDepositar;
import com.andre.APIBanco.models.Transferencia;
import com.andre.APIBanco.services.TransacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class TransacoesController {
    @Autowired
    TransacoesService transacoesService;

    @PostMapping("/transferir/{senha}")
    public String transferir(@RequestBody Transferencia transferencia, @PathVariable("senha") String senha) {
        return transacoesService.transferir(transferencia.getNumContaOrigem(),
                                            transferencia.getNumContaDestino(),
                                            transferencia.getValor(),
                                            senha);
    }

    @PostMapping("/sacar/{senha}")
    public String transferir(@RequestBody SacarDepositar sacar, @PathVariable("senha") String senha) {
        return transacoesService.sacar(sacar.getNumConta(), sacar.getValor(), senha);
    }

    @PostMapping("/depositar/{senha}")
    public String depositar(@RequestBody SacarDepositar depositar, @PathVariable("senha") String senha) {
        return transacoesService.depositar(depositar.getNumConta(), depositar.getValor(), senha);
    }
}
