package com.bootcamp.grupo4.restaurante.services;

import com.bootcamp.grupo4.restaurante.entities.Caixa;
import com.bootcamp.grupo4.restaurante.repository.CaixaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaixaService {
    private final CaixaRepository caixaRepository;

    @Autowired
    CaixaService (CaixaRepository caixaRepository) {
        this.caixaRepository = caixaRepository;
    }

    public void fecharMesa(double valorTotalConsumido) {
        Caixa caixa = this.caixaRepository.find();
        caixa.setValor(
                caixa.getValor() + valorTotalConsumido
        );

        this.caixaRepository.atualizaCaixa(caixa);
    }

    public Caixa retornarCaixa(Long id) {
        return this.caixaRepository.find(id);
    }
}
