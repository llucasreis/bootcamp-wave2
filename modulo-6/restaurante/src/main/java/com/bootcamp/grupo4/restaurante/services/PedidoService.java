package com.bootcamp.grupo4.restaurante.services;

import com.bootcamp.grupo4.restaurante.dtos.PedidoFormDTO;
import com.bootcamp.grupo4.restaurante.entities.Mesa;
import com.bootcamp.grupo4.restaurante.entities.Pedido;
import com.bootcamp.grupo4.restaurante.entities.Prato;
import com.bootcamp.grupo4.restaurante.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final MesaService mesaService;
    private final MesaRepository mesaRepository;

    @Autowired
    PedidoService (MesaService mesaService, MesaRepository mesaRepository) {
        this.mesaService = mesaService;
        this.mesaRepository = mesaRepository;
    }

    public Pedido adicionarPedido(PedidoFormDTO pedidoFormDTO) {
        Mesa mesa = this.mesaRepository.findOne(pedidoFormDTO.getMesa());

        double valorTotal = pedidoFormDTO.getPratos()
                .stream().mapToDouble(Prato::preco).sum();

        Pedido pedido = pedidoFormDTO.converter(
                this.mesaRepository.getProximoPedidoId(mesa.getId()),
                mesa, valorTotal);

        this.mesaService.adicionarPedido(pedido);

        return pedido;
    }
}
