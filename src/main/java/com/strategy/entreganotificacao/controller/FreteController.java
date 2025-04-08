package com.strategy.entreganotificacao.controller;

import com.strategy.entreganotificacao.service.FreteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/frete")
public class FreteController {
    private final FreteService freteService;

    public FreteController(FreteService freteService) {
        this.freteService = freteService;
    }

    @GetMapping
    public String mostrarFrete(@RequestParam String modalidade, @RequestParam Double peso) {
        Double valorFrete = freteService.calcularFrete(modalidade, peso);

        return "Valor do frete da modalidade " + modalidade + " e peso " + peso + " é: R$" + valorFrete;
    }
}
