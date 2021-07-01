package com.bootcamp.grupo4.restaurante.controllers;

import com.bootcamp.grupo4.restaurante.dtos.PedidoDTO;
import com.bootcamp.grupo4.restaurante.dtos.PedidoFormDTO;
import com.bootcamp.grupo4.restaurante.entities.Pedido;
import com.bootcamp.grupo4.restaurante.entities.Prato;
import com.bootcamp.grupo4.restaurante.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private PedidoService pedidoService;

    @Autowired
    PedidoController (PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    /*
    Exemplo de pedido
    {
	"mesa": 1,
	"pratos": [
		{
			"id": 1,
			"preco": 30.0,
			"descricao": "Peru",
			"quantidade": 1
		},
		{
			"id": 2,
			"preco": 5.0,
			"descricao": "Bolinho",
			"quantidade": 5
		}
	  ]
    }
     */
    @PostMapping
    public ResponseEntity<PedidoDTO> adicionarPedido(@RequestBody PedidoFormDTO pedidoFormDTO) {
        Pedido pedido = this.pedidoService.adicionarPedido(pedidoFormDTO);

        return new ResponseEntity<>(PedidoDTO.converter(pedido), HttpStatus.OK);
    }
}
