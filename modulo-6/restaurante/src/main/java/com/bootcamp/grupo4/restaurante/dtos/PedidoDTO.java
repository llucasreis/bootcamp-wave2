package com.bootcamp.grupo4.restaurante.dtos;

import com.bootcamp.grupo4.restaurante.entities.Pedido;
import com.bootcamp.grupo4.restaurante.entities.Prato;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoDTO {
    private Long id;
    private double valorTotal;
    private List<Prato> pratos;
    private boolean pedidoAtivo;
    private String data;

    public PedidoDTO(Long id, double valorTotal, List<Prato> pratos,
                     boolean pedidoAtivo, String data) {
        this.id = id;
        this.valorTotal = valorTotal;
        this.pratos = pratos;
        this.pedidoAtivo = pedidoAtivo;
        this.data = data;
    }

    public static PedidoDTO converter(Pedido pedido) {
        return new PedidoDTO(
                pedido.getId(),
                pedido.getValorTotal(),
                pedido.getPratos(),
                pedido.isPedidoAtivo(),
                pedido.getData()
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

    public boolean isPedidoAtivo() {
        return pedidoAtivo;
    }

    public void setPedidoAtivo(boolean pedidoAtivo) {
        this.pedidoAtivo = pedidoAtivo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
