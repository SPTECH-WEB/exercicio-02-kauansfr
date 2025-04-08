package com.strategy.entreganotificacao.service;

import com.strategy.entreganotificacao.service.strategy.FreteStrategy;
import org.springframework.stereotype.Component;

@Component
public class FreteTerceirizada implements FreteStrategy {
    @Override
    public Double calcularFrete(Double peso) {
        return peso * 5.0;
    }

    @Override
    public String modalidade() {
        return "terceirizada";
    }
}