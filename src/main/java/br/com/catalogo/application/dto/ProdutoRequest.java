package br.com.catalogo.application.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProdutoRequest(
    String nome,
    String descricao,
    BigDecimal preco,
    String moeda,
    String unidadeManutencaoEstoque,
    UUID categoriaId
) {}
