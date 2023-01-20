package com.andre.APIBanco.services;

import com.andre.APIBanco.models.Conta;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface ContaService {
    List<Conta> buscarTodas();

    Conta buscarPorId(long id);

    String criar(Conta conta);

    void atualizarSaldo(long id, BigDecimal novoSaldo);

    String atualizar(Conta conta, String senha);

    String deletar(long id, String senha);
}
