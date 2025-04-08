package com.strategy.entreganotificacao.service;

import com.strategy.entreganotificacao.service.strategy.FreteStrategy;
import org.springframework.stereotype.Component;

@Component
public class FreteExpresso implements FreteStrategy {
    @Override
    public Double calcularFrete(Double peso) {
        return peso * 9.0;
    }

    @Override
    public String modalidade() {
        return "expresso";
    }
}
