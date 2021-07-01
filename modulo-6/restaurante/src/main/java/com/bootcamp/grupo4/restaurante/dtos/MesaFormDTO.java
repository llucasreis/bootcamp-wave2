package com.bootcamp.grupo4.restaurante.dtos;

import java.util.List;

public class MesaFormDTO {
    private List<PedidoFormDTO> pedidos;

    public MesaFormDTO(List<PedidoFormDTO> pedidos) {
        this.pedidos = pedidos;
    }

    public List<PedidoFormDTO> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<PedidoFormDTO> pedidos) {
        this.pedidos = pedidos;
    }
}
