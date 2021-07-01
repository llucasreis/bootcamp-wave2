package com.bootcamp.grupo4.restaurante.repository;

import com.bootcamp.grupo4.restaurante.entities.Mesa;
import com.bootcamp.grupo4.restaurante.entities.Pedido;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MesaRepository {
    private final List<Mesa> mesaList;

    MesaRepository() {
        this.mesaList = new ArrayList<>(Arrays.asList(
                new Mesa(1L),
                new Mesa(2L),
                new Mesa(3L),
                new Mesa(4L)
        ));
    }

    private int findIndex(Long id) {
        int arrayIndex = -1;
        for (int i = 0; i< this.mesaList.size(); i++) {
            if (this.mesaList.get(i).getId().equals(id)) {
                arrayIndex = i;
            }
        }

        return arrayIndex;
    }

    public Mesa findOne(Long id) {
        return this.mesaList.stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);
    }

    public Long getProximoPedidoId(Long id) {
        List<Pedido> pedidos = this.findOne(id).getPedidos();

        if (pedidos.size() == 0) {
            return 1L;
        }
        Pedido ultimoPedido = pedidos.get(pedidos.size() - 1);

        return ultimoPedido.getId()+1;
    }

    public void atualizarMesa(Mesa mesa) {
        int index = this.findIndex(mesa.getId());

        this.mesaList.set(index, mesa);
    }
}
