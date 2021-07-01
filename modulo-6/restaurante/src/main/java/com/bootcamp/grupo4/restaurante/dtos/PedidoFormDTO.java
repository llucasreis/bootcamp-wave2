package com.bootcamp.grupo4.restaurante.dtos;

import com.bootcamp.grupo4.restaurante.entities.Mesa;
import com.bootcamp.grupo4.restaurante.entities.Pedido;
import com.bootcamp.grupo4.restaurante.entities.Prato;

import java.util.List;

public class PedidoFormDTO {
    private Long mesa;
    private List<Prato> pratos;

    public PedidoFormDTO(Long mesa, List<Prato> pratos) {
        this.mesa = mesa;
        this.pratos = pratos;
    }

    public Pedido converter(Long id, Mesa mesa, double valorTotal) {
        return new Pedido(id, mesa, this.pratos, valorTotal);
    }

    public Long getMesa() {
        return mesa;
    }

    public void setMesa(Long mesa) {
        this.mesa = mesa;
    }

    public List<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
    }
}
