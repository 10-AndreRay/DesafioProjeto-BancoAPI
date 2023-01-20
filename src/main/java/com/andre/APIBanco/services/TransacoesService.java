package com.andre.APIBanco.services;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public interface TransacoesService {
    String transferir(long numContaOrigem, long numContaDestino,  BigDecimal valor, String senha);

    String sacar(long numContaOrigem, BigDecimal valor, String senha);

    String depositar(long numContaOrigem, BigDecimal valor, String senha);
}
