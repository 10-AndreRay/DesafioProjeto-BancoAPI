package com.andre.APIBanco.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class SacarDepositar {
    private long numConta;
    private BigDecimal valor;
}
