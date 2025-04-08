package com.strategy.entreganotificacao.controller;

import com.strategy.entreganotificacao.service.FreteService;
import com.strategy.entreganotificacao.service.strategy.FreteStrategy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/frete")
public class FreteController {
    private final FreteStrategy freteStrategy;
    private final FreteService freteService;

    public FreteController(@Qualifier("transportadoraExterna") FreteStrategy freteStrategy, FreteService freteService) {
        this.freteStrategy = freteStrategy;
        this.freteService = freteService;
    }

    @GetMapping
    public String mostrarFrete(@RequestParam String modalidade, @RequestParam Double peso) {
        Double valorFrete = freteService.calcularFrete(modalidade, peso);

        return "Valor do frete da modalidade " + modalidade + " e peso " + peso + " é: R$" + valorFrete;
    }

    @GetMapping("transportadoraExterna")
    public String mostrarFrete(@RequestParam Double peso) {
        Double valorFrete = freteStrategy.calcularFrete(peso);

        return "Valor do frete da modalidade transporadora externa " + "e peso " + peso + " é: R$" + valorFrete;
    }
}
