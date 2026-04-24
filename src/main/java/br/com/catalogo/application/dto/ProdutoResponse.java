package br.com.catalogo.application.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProdutoResponse(
    UUID id,
    String nome,
    BigDecimal preco,
    String moeda,
    String unidadeManutencaoEstoque,
    boolean ativo
) {}

