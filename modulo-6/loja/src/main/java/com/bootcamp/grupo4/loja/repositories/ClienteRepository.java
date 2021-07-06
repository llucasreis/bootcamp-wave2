package com.bootcamp.grupo4.loja.repositories;

import com.bootcamp.grupo4.loja.entities.Cliente;
import com.bootcamp.grupo4.loja.entities.Pedido;
import com.bootcamp.grupo4.loja.repositories.dao.ClienteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteRepository {
    private final ClienteDAO clienteDAO;

    @Autowired
    ClienteRepository(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    private int findIndex(List<Cliente> clientes, Long id) {
        int arrayIndex = -1;
        for (int i = 0; i<clientes.size(); i++) {
            if (clientes.get(i).getId().equals(id)) {
                arrayIndex = i;
            }
        }

        return arrayIndex;
    }

    public List<Cliente> find() {
        return this.clienteDAO.find();
    }

    public Cliente findOne(Long id) {
        return this.find().stream()
                .filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    public Pedido findPedido(Cliente cliente, Long id) {
        List<Pedido> pedidos = cliente.getPedidos();

        return pedidos.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    public Long getProximoPedidoId(Long id) {
        List<Pedido> pedidos = this.findOne(id).getPedidos();

        if (pedidos.size() == 0) {
            return 1L;
        }
        Pedido ultimoPedido = pedidos.get(pedidos.size() - 1);

        return ultimoPedido.getId()+1;
    }

    public boolean atualizarCliente(Cliente cliente) {
        List<Cliente> clientes = this.find();

        int index = this.findIndex(clientes, cliente.getId());

        clientes.set(index, cliente);

        return this.clienteDAO.atualizarCliente(clientes);
    }
}
