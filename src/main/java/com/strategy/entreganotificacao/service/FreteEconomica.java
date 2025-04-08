package com.strategy.entreganotificacao.service;

import com.strategy.entreganotificacao.service.strategy.FreteStrategy;
import org.springframework.stereotype.Component;

@Component
public class FreteEconomica implements FreteStrategy {
    @Override
    public Double calcularFrete(Double peso) {
        return peso * 2.5;
    }

    @Override
    public String modalidade() {
        return "economica";
    }
}