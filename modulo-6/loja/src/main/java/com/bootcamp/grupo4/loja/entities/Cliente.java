package com.bootcamp.grupo4.loja.entities;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private List<Pedido> pedidos;

    public Cliente(Long id, String nome, String cpf, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.pedidos = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void adicionarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public void atualizarPedido(Pedido pedido) {
        int arrayIndex = -1;
        for (int i = 0; i<this.pedidos.size(); i++) {
            if (this.pedidos.get(i).getId().equals(pedido.getId())) {
                arrayIndex = i;
            }
        }

        this.pedidos.set(arrayIndex, pedido);
    }

    public void removerPedido(Pedido pedido) {
        this.pedidos.remove(pedido);
    }
}
