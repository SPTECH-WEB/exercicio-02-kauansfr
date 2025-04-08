package com.strategy.entreganotificacao.service.strategy;

public interface FreteStrategy {
    Double calcularFrete(Double peso);
    String modalidade();
}