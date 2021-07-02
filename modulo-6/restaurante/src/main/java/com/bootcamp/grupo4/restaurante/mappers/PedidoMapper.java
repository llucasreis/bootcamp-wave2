package com.bootcamp.grupo4.restaurante.mappers;

import com.bootcamp.grupo4.restaurante.entities.Mesa;
import com.bootcamp.grupo4.restaurante.entities.Pedido;
import com.bootcamp.grupo4.restaurante.entities.Prato;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoMapper {
    private Long id;
    private List<Prato> pratos;
    private double valorTotal;
    private boolean pedidoAtivo;
    private String data;

    public PedidoMapper(Long id, List<Prato> pratos,
                        double valorTotal, boolean pedidoAtivo, String data) {
        this.id = id;
        this.pratos = pratos;
        this.valorTotal = valorTotal;
        this.pedidoAtivo = pedidoAtivo;
        this.data = data;
    }

    public static PedidoMapper toPersistence(Pedido pedido) {
        return new PedidoMapper(
                pedido.getId(),
                pedido.getPratos(),
                pedido.getValorTotal(),
                pedido.isPedidoAtivo(),
                pedido.getData()
        );
    }

    public static Pedido toDomain(PedidoMapper pedidoMapper, Mesa mesa) {
        return new Pedido(
                pedidoMapper.getId(),
                mesa,
                pedidoMapper.getPratos(),
                pedidoMapper.getValorTotal(),
                pedidoMapper.isPedidoAtivo(),
                pedidoMapper.getData()
        );
    }

    public static List<PedidoMapper> toPersistence(List<Pedido> pedidos) {
        return pedidos.stream().map(PedidoMapper::toPersistence).collect(Collectors.toList());
    }

    public static List<Pedido> toDomain(List<PedidoMapper> pedidoMappers, Mesa mesa) {
        return pedidoMappers.stream().map(
                p -> PedidoMapper.toDomain(p, mesa)
        ).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
