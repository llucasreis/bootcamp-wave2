package com.bootcamp.grupo4.restaurante.controllers;

import com.bootcamp.grupo4.restaurante.dtos.MesaDTO;
import com.bootcamp.grupo4.restaurante.entities.Mesa;
import com.bootcamp.grupo4.restaurante.services.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mesa")
public class MesaController {

    private MesaService mesaService;

    @Autowired
    public MesaController(MesaService mesaService) {
        this.mesaService = mesaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MesaDTO> retornarPedidos(@PathVariable Long id, @RequestParam(required = false) String ativos) {
        Mesa mesa = this.mesaService.retornarPedidos(id, ativos);

        if (mesa != null) {
            return new ResponseEntity<>(MesaDTO.converter(mesa), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/fechar")
    public ResponseEntity<MesaDTO> fecharMesa(@PathVariable Long id) {
        Mesa mesa = this.mesaService.fecharMesa(id);

        if (mesa != null) {
            return new ResponseEntity<>(MesaDTO.converter(mesa), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
