package com.bootcamp.grupo4.restaurante.entities;

import com.bootcamp.grupo4.restaurante.utils.DataUtil;

import java.util.List;

public class Pedido {
    private Long id;
    private Mesa mesa;
    private List<Prato> pratos;
    private double valorTotal;
    private boolean pedidoAtivo;
    private String data;

    public Pedido(Mesa mesa, List<Prato> pratos, double valorTotal) {
        this.mesa = mesa;
        this.pratos = pratos;
        this.valorTotal = valorTotal;
        this.pedidoAtivo = true;
        this.data = DataUtil.getDataAtual();
    }

    public Pedido(Long id, Mesa mesa, List<Prato> pratos,
                  double valorTotal, boolean pedidoAtivo, String data) {
        this.id = id;
        this.mesa = mesa;
        this.pratos = pratos;
        this.valorTotal = valorTotal;
        this.pedidoAtivo = pedidoAtivo;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
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

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", valorTotal=" + valorTotal +
                ", pedidoAtivo=" + pedidoAtivo +
                '}';
    }
}
