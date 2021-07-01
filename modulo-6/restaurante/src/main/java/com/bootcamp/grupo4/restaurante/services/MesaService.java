package com.bootcamp.grupo4.restaurante.services;

import com.bootcamp.grupo4.restaurante.entities.Mesa;
import com.bootcamp.grupo4.restaurante.entities.Pedido;
import com.bootcamp.grupo4.restaurante.repository.CaixaRepository;
import com.bootcamp.grupo4.restaurante.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MesaService {

    private final MesaRepository mesaRepository;
    private final CaixaService caixaService;

    @Autowired
    MesaService(MesaRepository mesaRepository, CaixaService caixaService) {
        this.mesaRepository = mesaRepository;
        this.caixaService = caixaService;
    }

    public Mesa adicionarPedido(Pedido pedido) {
        Mesa mesa = this.mesaRepository.findOne(pedido.getMesa().getId());

        if (mesa != null) {
            mesa.adicionarPedido(pedido);
            mesa.setValorTotalConsumido(
                    mesa.getValorTotalConsumido()
                    + pedido.getValorTotal()
            );

            this.mesaRepository.atualizarMesa(mesa);

            return mesa;
        } else {
            return null;
        }
    }

    public Mesa retornarPedidos(Long id) {
        return this.mesaRepository.findOne(id);
    }

    public Mesa fecharMesa(Long id) {
        Mesa mesa = this.mesaRepository.findOne(id);

        if (mesa != null) {
            this.caixaService.fecharMesa(mesa.getValorTotalConsumido());

            mesa.setPedidos(new ArrayList<>());
            mesa.setValorTotalConsumido(0.0);

            this.mesaRepository.atualizarMesa(mesa);

            return mesa;
        } else {
            return null;
        }
    }

}
