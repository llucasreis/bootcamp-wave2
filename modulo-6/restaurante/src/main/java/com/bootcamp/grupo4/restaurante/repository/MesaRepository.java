package com.bootcamp.grupo4.restaurante.repository;

import com.bootcamp.grupo4.restaurante.entities.Mesa;
import com.bootcamp.grupo4.restaurante.entities.Pedido;
import com.bootcamp.grupo4.restaurante.mappers.MesaMapper;
import com.bootcamp.grupo4.restaurante.repository.dao.MesaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MesaRepository {
    private final MesaDAO mesaDAO;

    @Autowired
    MesaRepository(MesaDAO mesaDAO) {
        this.mesaDAO = mesaDAO;
    }

    private int findIndex(List<Mesa> mesaList, Long id) {
        int arrayIndex = -1;
        for (int i = 0; i< mesaList.size(); i++) {
            if (mesaList.get(i).getId().equals(id)) {
                arrayIndex = i;
            }
        }

        return arrayIndex;
    }

    public List<Mesa> find() {
        return this.mesaDAO.find();
    }

    public Mesa findOne(Long id) {
        return this.mesaDAO.findOne(id);
    }

    public Mesa findWithPedidosAtivos(Long id) {
        Mesa mesa = this.mesaDAO.findOne(id);

        if (mesa != null) {
            mesa.setPedidos(
                    mesa.getPedidos().stream()
                            .filter(Pedido::isPedidoAtivo).collect(Collectors.toList())
            );

            return mesa;
        }
        return null;
    }

    public Mesa findWithPedidosNaoAtivos(Long id) {
        Mesa mesa = this.mesaDAO.findOne(id);

        if (mesa != null) {
            mesa.setPedidos(
                    mesa.getPedidos().stream()
                            .filter(p -> !p.isPedidoAtivo()).collect(Collectors.toList())
            );

            return mesa;
        }
        return null;
    }

    public Long getProximoPedidoId(Long id) {
        List<Pedido> pedidos = this.findOne(id).getPedidos();

        if (pedidos.size() == 0) {
            return 1L;
        }
        Pedido ultimoPedido = pedidos.get(pedidos.size() - 1);

        return ultimoPedido.getId()+1;
    }

    public boolean atualizarMesa(Mesa mesa) {
        List<Mesa> mesas = this.find();

        int index = this.findIndex(mesas, mesa.getId());

        mesas.set(index, mesa);

        return this.mesaDAO.atualizarMesa(MesaMapper.toPersistence(mesas));
    }
}
