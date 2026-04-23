package br.com.catalogo.domain.model;

import java.math.BigDecimal;

import br.com.catalogo.domain.exception.PrecoInvalidoException;

public record Preco(BigDecimal valor, String moeda) {
    public Preco {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new PrecoInvalidoException("O preço não pode ser negativo");
        }
        if (moeda == null || moeda.isBlank()) {
            moeda = "BRL";
        }
    }
}

