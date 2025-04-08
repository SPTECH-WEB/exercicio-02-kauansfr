package com.strategy.entreganotificacao.service;

import com.strategy.entreganotificacao.service.strategy.FreteStrategy;
import org.springframework.stereotype.Service;

@Service("cupomFrete")
public class FreteCupomDescontoAdapter implements FreteStrategy {
    private final FreteExpresso freteExpresso;

    public FreteCupomDescontoAdapter(FreteExpresso freteExpresso) {
        this.freteExpresso = freteExpresso;
    }

    @Override
    public Double calcularFrete(Double peso) {
        Double frete = freteExpresso.calcularFrete(peso);

        return frete - (frete * 0.5);
    }

    @Override
    public String modalidade() {
        return "cupomFrete";
    }
}
