package com.bootcamp.grupo4.restaurante.entities;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private Long id;
    private List<Pedido> pedidos;
    private double valorTotalConsumido;

    public Mesa(Long id) {
        this.id = id;
        this.pedidos = new ArrayList<>();
        this.valorTotalConsumido = 0.0;
    }

    public Mesa(Long id, List<Pedido> pedidos, double valorTotalConsumido) {
        this.id = id;
        this.pedidos = pedidos;
        this.valorTotalConsumido = valorTotalConsumido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public double getValorTotalConsumido() {
        return valorTotalConsumido;
    }

    public void setValorTotalConsumido(double valorTotalConsumido) {
        this.valorTotalConsumido = valorTotalConsumido;
    }

    public void adicionarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }
}
