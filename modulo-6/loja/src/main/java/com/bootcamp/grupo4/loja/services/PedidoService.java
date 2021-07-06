package com.bootcamp.grupo4.loja.services;

import com.bootcamp.grupo4.loja.dtos.PedidoFormDTO;
import com.bootcamp.grupo4.loja.entities.Cliente;
import com.bootcamp.grupo4.loja.entities.Pedido;
import com.bootcamp.grupo4.loja.entities.Produto;
import com.bootcamp.grupo4.loja.repositories.ClienteRepository;
import com.bootcamp.grupo4.loja.utils.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
                    valorTotal, DataUtil.getDataAtual());

            if (this.clienteService.adicionarPedido(cliente.getId(), pedido)) {
                return pedido;
            }
        }
        return null;
    }

    public Pedido atualizarPedido(Long id, PedidoFormDTO pedidoFormDTO) {
        Cliente cliente = this.clienteRepository.findOne(pedidoFormDTO.getCliente());

        if (cliente != null) {
            Pedido pedido = this.clienteRepository.findPedido(cliente, id);

            if (pedido != null) {
                double valorTotal = pedidoFormDTO.getProdutos()
                        .stream().mapToDouble(Produto::valor).sum();

                Pedido pedidoAtualizado = pedidoFormDTO.converter(
                        pedido.getId(),
                        valorTotal,
                        pedido.getData()
                );
                if (this.clienteService.atualizarPedido(cliente, pedidoAtualizado)) {
                    return pedidoAtualizado;
                }
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

    public boolean removerPedido(Long id, Long clientId) {
        Cliente cliente = this.clienteRepository.findOne(clientId);

        if (cliente != null) {
            Pedido pedido = this.clienteRepository.findPedido(cliente, id);

            if (pedido != null) {
                return this.clienteService.removerPedido(cliente, pedido);
            }
        }
        return false;
    }

    public List<Pedido> pedidosDoDia(String data) {
        String dataFinal = DataUtil.converterFormato(data);
        List<Cliente> clientes = this.clienteRepository.find();
        List<Pedido> pedidosDoDia = new ArrayList<>();

        clientes.forEach(cliente -> {
            List<Pedido> pedidos = cliente.getPedidos().stream()
                    .filter(p -> p.getData().equals(dataFinal)).collect(Collectors.toList());

            pedidosDoDia.addAll(pedidos);
        });

        return pedidosDoDia;
    }
}
