package com.bootcamp.grupo4.loja.repositories;

import com.bootcamp.grupo4.loja.entities.Cliente;
import com.bootcamp.grupo4.loja.entities.Pedido;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ClienteRepository {

    private final List<Cliente> clienteList;

    ClienteRepository() {
        this.clienteList = new ArrayList<>(Arrays.asList(
                new Cliente(1L, "Lucas", "73874734048", "lucas@gmail.com", "987339065"),
                new Cliente(2L, "Emily", "19962680077", "emily@gmail.com", "987339064")
        ));
    }

    private int findIndex(Long id) {
        int arrayIndex = -1;
        for (int i = 0; i< this.clienteList.size(); i++) {
            if (this.clienteList.get(i).getId().equals(id)) {
                arrayIndex = i;
            }
        }

        return arrayIndex;
    }

    public Cliente findOne(Long id) {
        return this.clienteList.stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);
    }

    public Long getProximoPedidoId(Long id) {
        List<Pedido> pedidos = this.findOne(id).getPedidos();

        if (pedidos.size() == 0) {
            return 1L;
        }
        Pedido ultimoPedido = pedidos.get(pedidos.size() - 1);

        return ultimoPedido.getId()+1;
    }

    public void atualizarCliente(Cliente cliente) {
        int index = this.findIndex(cliente.getId());

        this.clienteList.set(index, cliente);
    }
}
