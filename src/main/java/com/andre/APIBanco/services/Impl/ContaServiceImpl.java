package com.andre.APIBanco.services.Impl;

import com.andre.APIBanco.models.Conta;
import com.andre.APIBanco.repositories.ContaRepository;
import com.andre.APIBanco.services.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ContaServiceImpl implements ContaService {
    @Autowired
    ContaRepository contaRepository;

    @Override
    public List<Conta> buscarTodas() {
        return contaRepository.findAll();
    }

    @Override
    public Conta buscarPorId(long id) {
        Optional<Conta> optional = contaRepository.findById(id);

        return optional.orElse(null);
    }

    @Override
    public String criar(Conta conta) {
        Optional<Conta> optional = contaRepository.findById(conta.getNumConta());

        if(optional.isPresent())
            return "Conta já existe";
        else{
            contaRepository.save(conta);
            return "Conta criada com sucesso! " + conta;
        }
    }

    @Override
    public String atualizar(Conta conta, String senha) {
        long id = conta.getNumConta();
        Conta contaEncontrada = buscarPorId(id);

        if(contaEncontrada == null)
            return "Conta inexistente";

        if(senha.equals(contaEncontrada.getSenha())) {
            contaRepository.save(conta);
            return "Conta atualizada com sucesso " + conta;
        } else
            return "Senha incorreta";
    }

    public void atualizarSaldo(long id, BigDecimal novoSaldo) {
        Conta contaEncontrada = buscarPorId(id);

        contaEncontrada.setSaldo(novoSaldo);

        contaRepository.save(contaEncontrada);
    }

    @Override
    public String deletar(long id, String senha) {
        Conta conta = buscarPorId(id);

        if(conta == null)
            return "Conta inexistente";

        if(senha.equals(conta.getSenha())) {
            contaRepository.deleteById(id);
            return "Conta deletada com sucesso " + conta;
        } else
            return "Senha incorreta";
    }
}
