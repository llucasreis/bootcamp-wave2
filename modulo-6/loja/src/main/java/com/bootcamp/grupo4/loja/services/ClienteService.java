package com.bootcamp.grupo4.loja.services;

import com.bootcamp.grupo4.loja.entities.Cliente;
import com.bootcamp.grupo4.loja.entities.Pedido;
import com.bootcamp.grupo4.loja.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public boolean adicionarPedido(Long id, Pedido pedido) {
        Cliente cliente = this.clienteRepository.findOne(id);

        if (cliente != null) {
            cliente.adicionarPedido(pedido);

            return this.clienteRepository.atualizarCliente(cliente);
        }
        return false;
    }

    public boolean atualizarPedido(Cliente cliente, Pedido pedido) {
        cliente.atualizarPedido(pedido);

        return this.clienteRepository.atualizarCliente(cliente);
    }

    public boolean removerPedido(Cliente cliente, Pedido pedido) {
        cliente.removerPedido(pedido);

        return this.clienteRepository.atualizarCliente(cliente);
    }
}
