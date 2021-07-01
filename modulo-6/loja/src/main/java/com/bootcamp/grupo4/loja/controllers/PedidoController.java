package com.bootcamp.grupo4.loja.controllers;

import com.bootcamp.grupo4.loja.dtos.PedidoFormDTO;
import com.bootcamp.grupo4.loja.entities.Pedido;
import com.bootcamp.grupo4.loja.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }


    /*
    * Exemplo de post
    * {
	"cliente": 2,
	"produtos": [
		{
			"id": 1,
			"descricao": "Blusa",
			"cor": "Azul",
			"quantidade": 2,
			"preco": 35.0
		},
		{
			"id": 2,
			"descricao": "Meia",
			"cor": "Branco",
			"quantidade": 4,
			"preco": 5.0
		}
	  ]
    }
     */
    @PostMapping
    public ResponseEntity<Pedido> adicionarPedido(@RequestBody PedidoFormDTO pedidoFormDTO) {
        Pedido pedido = this.pedidoService.adicionarPedido(pedidoFormDTO);

        if (pedido != null) {
            return new ResponseEntity<>(pedido, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<Pedido>> retornarPedidosPorCliente(@PathVariable Long id) {
        List<Pedido> pedidos = this.pedidoService.retornarPedidosPorCliente(id);

        if (pedidos != null) {
            return new ResponseEntity<>(pedidos, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

}
