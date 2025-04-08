package com.strategy.entreganotificacao.service;

import com.strategy.entreganotificacao.service.strategy.FreteStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreteService {
    private final List<FreteStrategy> estrategias;

    public FreteService(List<FreteStrategy> estrategias) {
        this.estrategias = estrategias;
    }

    public Double calcularFrete(String modalidade, Double peso) {
        return estrategias.stream()
                .filter(estrategia -> estrategia.modalidade().equalsIgnoreCase(modalidade))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Tipo de frete inválido"))
                .calcularFrete(peso);
    }
}
