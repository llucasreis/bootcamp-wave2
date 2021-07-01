package com.bootcamp.grupo4.restaurante.controllers;

import com.bootcamp.grupo4.restaurante.entities.Caixa;
import com.bootcamp.grupo4.restaurante.services.CaixaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/caixa")
public class CaixaController {

    private CaixaService caixaService;

    @Autowired
    CaixaController(CaixaService caixaService) {
        this.caixaService = caixaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Caixa> retornarCaixa(@PathVariable Long id) {
        Caixa caixa = this.caixaService.retornarCaixa(id);

        if (caixa != null) {
            return new ResponseEntity<>(caixa, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }
}
