package com.bootcamp.grupo4.loja.dtos;

import com.bootcamp.grupo4.loja.entities.Pedido;
import com.bootcamp.grupo4.loja.entities.Produto;

import java.util.List;

public class PedidoFormDTO {
    private Long cliente;
    private List<Produto> produtos;

    public PedidoFormDTO(Long cliente, List<Produto> produtos) {
        this.cliente = cliente;
        this.produtos = produtos;
    }

    public Pedido converter(Long id, double valorTotal, String data) {
        return new Pedido(
                id,
                this.produtos,
                valorTotal,
                data);
    }

    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
