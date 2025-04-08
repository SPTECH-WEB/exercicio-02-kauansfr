package com.strategy.entreganotificacao.service;

import com.strategy.entreganotificacao.service.strategy.FreteStrategy;
import org.springframework.stereotype.Service;

@Service("transportadoraExterna")
public class TransportadoraExterna implements FreteStrategy {
    private final FreteExpresso freteExpresso;

    public TransportadoraExterna(FreteExpresso freteExpresso) {
        this.freteExpresso = freteExpresso;
    }

    @Override
    public Double calcularFrete(Double peso) {
        Double frete = freteExpresso.calcularFrete(peso);

        return frete - (frete * 0.5);
    }

    @Override
    public String modalidade() {
        return "transportadoraExterna";
    }
}
