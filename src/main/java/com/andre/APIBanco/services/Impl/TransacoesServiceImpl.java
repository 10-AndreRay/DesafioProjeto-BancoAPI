package com.andre.APIBanco.services.Impl;

import com.andre.APIBanco.models.Conta;
import com.andre.APIBanco.services.ContaService;
import com.andre.APIBanco.services.TransacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransacoesServiceImpl implements TransacoesService {
    @Autowired
    ContaService contaService;

    @Override
    public String transferir(long numContaOrigem, long numContaDestino, BigDecimal valor, String senha) {
        Conta contaOrigem = contaService.buscarPorId(numContaOrigem);
        Conta contaDestino = contaService.buscarPorId(numContaDestino);

        if(contaDestino == null || contaOrigem == null)
            return "Operação não realizada, verifique o id das contas e tente novamente!";

        if(senha.equals(contaOrigem.getSenha())) {
            if(contaOrigem.getSaldo().compareTo(valor) >= 0) {
                contaService.atualizarSaldo(numContaOrigem, contaOrigem.getSaldo().subtract(valor));
                contaService.atualizarSaldo(numContaDestino, contaDestino.getSaldo().add(valor));
                return "Transação Completa! Foram transferidos " + valor + " para a conta com titular de nome " + contaDestino.getNomeTitular();
            } else
                return "Saldo insuficiente";
        } else
            return "Senha incorreta";

    }

    @Override
    public String sacar(long numContaOrigem, BigDecimal valor, String senha) {
        Conta contaOrigem = contaService.buscarPorId(numContaOrigem);

        if(contaOrigem == null)
            return "Conta inexistente";

        if(senha.equals(contaOrigem.getSenha())) {
            if(contaOrigem.getSaldo().compareTo(valor) >= 0) {
                BigDecimal novoSaldo = contaOrigem.getSaldo().subtract(valor);
                contaService.atualizarSaldo(numContaOrigem, novoSaldo);
                return "Transação Completa! Foram sacados R$" + valor + ". Novo saldo=" + novoSaldo;
            } else
                return "Saldo insuficiente";
        } else
            return "Senha incorreta";
    }

    @Override
    public String depositar(long numContaOrigem, BigDecimal valor, String senha) {
        Conta contaOrigem = contaService.buscarPorId(numContaOrigem);

        if(contaOrigem == null)
            return "Conta inexistente";

        if(senha.equals(contaOrigem.getSenha())) {
            BigDecimal novoSaldo = contaOrigem.getSaldo().add(valor);
            contaService.atualizarSaldo(numContaOrigem, novoSaldo);
            return "Transação Completa! Foram depositados R$" + valor + ". Novo saldo=" + novoSaldo;
        } else
            return "Senha incorreta";
    }
}
