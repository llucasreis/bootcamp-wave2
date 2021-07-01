package com.bootcamp.grupo4.restaurante.dtos;

import com.bootcamp.grupo4.restaurante.entities.Pedido;
import com.bootcamp.grupo4.restaurante.entities.Prato;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoDTO {
    private Long id;
    private double valorTotal;
    private List<Prato> pratos;

    public PedidoDTO(Long id, double valorTotal, List<Prato> pratos) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.pratos = pratos;
    }

    public static PedidoDTO converter(Pedido pedido) {
        return new PedidoDTO(
                pedido.getId(),
                pedido.getValorTotal(),
                pedido.getPratos()
        );
    }

    public static List<PedidoDTO> converter(List<Pedido> pedidos) {
        return pedidos.stream().map(PedidoDTO::converter).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
    }
}
