package com.bootcamp.grupo4.morse.controller;

import com.bootcamp.grupo4.morse.entities.Palavra;
import com.bootcamp.grupo4.morse.service.TranslationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/translate")
public class TranslationController {

    @GetMapping("/{morse}")
    public Palavra translate(@PathVariable String morse) {
        String resultado = TranslationService.translate(morse);

        return new Palavra(resultado, morse);
    }
}
