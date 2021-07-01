package com.bootcamp.grupo4.restaurante.dtos;

import com.bootcamp.grupo4.restaurante.entities.Mesa;

import java.util.List;

public class MesaDTO {
    private Long id;
    private List<PedidoDTO> pedidos;
    private double valorTotalConsumido;

    public MesaDTO(Long id, List<PedidoDTO> pedidos, double valorTotalConsumido) {
        this.id = id;
        this.pedidos = pedidos;
        this.valorTotalConsumido = valorTotalConsumido;
    }

    public static MesaDTO converter(Mesa mesa) {
        return new MesaDTO(
                mesa.getId(),
                PedidoDTO.converter(mesa.getPedidos()),
                mesa.getValorTotalConsumido());
    }

    public List<PedidoDTO> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidoDTO> pedidos) {
        this.pedidos = pedidos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValorTotalConsumido() {
        return valorTotalConsumido;
    }

    public void setValorTotalConsumido(double valorTotalConsumido) {
        this.valorTotalConsumido = valorTotalConsumido;
    }
}
