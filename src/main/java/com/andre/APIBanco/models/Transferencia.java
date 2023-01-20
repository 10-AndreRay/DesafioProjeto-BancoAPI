package com.andre.APIBanco.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class Transferencia {
    private long numContaOrigem;

    private long numContaDestino;

    private BigDecimal valor;
}
