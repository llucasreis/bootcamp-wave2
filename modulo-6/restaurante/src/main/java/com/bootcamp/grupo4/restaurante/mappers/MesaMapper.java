package com.bootcamp.grupo4.restaurante.mappers;

import com.bootcamp.grupo4.restaurante.dtos.PedidoDTO;
import com.bootcamp.grupo4.restaurante.entities.Mesa;
import com.bootcamp.grupo4.restaurante.entities.Pedido;

import java.util.List;
import java.util.stream.Collectors;

public class MesaMapper {
    private Long id;
    private List<PedidoMapper> pedidos;
    private double valorTotalConsumido;

    public MesaMapper(Long id, List<PedidoMapper> pedidos, double valorTotalConsumido) {
        this.id = id;
        this.pedidos = pedidos;
        this.valorTotalConsumido = valorTotalConsumido;
    }

    public static MesaMapper toPersistence(Mesa mesa) {
        return new MesaMapper(
                mesa.getId(),
                PedidoMapper.toPersistence(mesa.getPedidos()),
                mesa.getValorTotalConsumido()
        );
    }

    public static Mesa toDomain(MesaMapper mesaMapper) {
        Mesa mesa = new Mesa(mesaMapper.getId());
        mesa.setValorTotalConsumido(mesaMapper.getValorTotalConsumido());
        mesa.setPedidos(PedidoMapper.toDomain(mesaMapper.getPedidos(), mesa));

        return mesa;
    }

    public static List<MesaMapper> toPersistence(List<Mesa> mesas) {
        return mesas.stream().map(MesaMapper::toPersistence).collect(Collectors.toList());
    }

    public static List<Mesa> toDomain(List<MesaMapper> mesaMappers) {
        return mesaMappers.stream().map(MesaMapper::toDomain).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PedidoMapper> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidoMapper> pedidos) {
        this.pedidos = pedidos;
    }

    public double getValorTotalConsumido() {
        return valorTotalConsumido;
    }

    public void setValorTotalConsumido(double valorTotalConsumido) {
        this.valorTotalConsumido = valorTotalConsumido;
    }
}
