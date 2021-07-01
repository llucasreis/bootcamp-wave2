package com.bootcamp.grupo4.loja.services;

import com.bootcamp.grupo4.loja.dtos.PedidoFormDTO;
import com.bootcamp.grupo4.loja.entities.Cliente;
import com.bootcamp.grupo4.loja.entities.Pedido;
import com.bootcamp.grupo4.loja.entities.Produto;
import com.bootcamp.grupo4.loja.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final ClienteRepository clienteRepository;
    private final ClienteService clienteService;

    @Autowired
    public PedidoService(ClienteRepository clienteRepository, ClienteService clienteService) {
        this.clienteRepository = clienteRepository;
        this.clienteService = clienteService;
    }

    public Pedido adicionarPedido(PedidoFormDTO pedidoFormDTO) {
        Cliente cliente = this.clienteRepository.findOne(pedidoFormDTO.getCliente());

        if (cliente != null) {
            double valorTotal = pedidoFormDTO.getProdutos()
                    .stream().mapToDouble(Produto::valor).sum();

            Pedido pedido = pedidoFormDTO.converter(
                    this.clienteRepository.getProximoPedidoId(cliente.getId()),
                    valorTotal);

            if (this.clienteService.adicionarPedido(cliente.getId(), pedido)) {
                return pedido;
            }
        }
        return null;
    }

    public List<Pedido> retornarPedidosPorCliente(Long id) {
        Cliente cliente = this.clienteRepository.findOne(id);

        if (cliente != null) {
            return cliente.getPedidos();
        }
        return null;
    }
}
