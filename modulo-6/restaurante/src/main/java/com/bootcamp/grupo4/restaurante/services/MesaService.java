package com.bootcamp.grupo4.restaurante.services;

import com.bootcamp.grupo4.restaurante.entities.Mesa;
import com.bootcamp.grupo4.restaurante.entities.Pedido;
import com.bootcamp.grupo4.restaurante.repository.CaixaRepository;
import com.bootcamp.grupo4.restaurante.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class MesaService {

    private final MesaRepository mesaRepository;
    private final CaixaService caixaService;

    @Autowired
    MesaService(MesaRepository mesaRepository, CaixaService caixaService) {
        this.mesaRepository = mesaRepository;
        this.caixaService = caixaService;
    }

    public boolean adicionarPedido(Pedido pedido) {
        Mesa mesa = this.mesaRepository.findOne(pedido.getMesa().getId());

        if (mesa != null) {
            mesa.adicionarPedido(pedido);
            mesa.setValorTotalConsumido(
                    mesa.getValorTotalConsumido()
                    + pedido.getValorTotal()
            );

            return this.mesaRepository.atualizarMesa(mesa);
        }
        return false;
    }

    public Mesa retornarPedidos(Long id, String ativos) {
        if (ativos == null || ativos.equals("") || ativos.equals("true")) {
            return this.mesaRepository.findWithPedidosAtivos(id);
        } else {
            return this.mesaRepository.findWithPedidosNaoAtivos(id);
        }

    }

    public Mesa fecharMesa(Long id) {
        Mesa mesa = this.mesaRepository.findOne(id);

        if (mesa != null) {
            this.caixaService.fecharMesa(mesa.getValorTotalConsumido());

            mesa.fecharPedidos();
            mesa.setValorTotalConsumido(0.0);

            if (this.mesaRepository.atualizarMesa(mesa)) {
                mesa.setPedidos(new ArrayList<>());
                return mesa;
            }
        }
        return null;
    }
}
