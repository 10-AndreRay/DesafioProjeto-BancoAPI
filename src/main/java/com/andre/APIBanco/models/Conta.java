package com.andre.APIBanco.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contas")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numConta;

    private String cpf;

    private String nomeTitular;

    private BigDecimal saldo;

    private String senha;

    @Override
    public String toString() {
        return "Conta{" +
                "numConta=" + numConta +
                ", cpf='" + cpf + '\'' +
                ", nomeTitular='" + nomeTitular + '\'' +
                ", saldo=" + saldo +
                ", senha='" + senha + '\'' +
                '}';
    }
}
