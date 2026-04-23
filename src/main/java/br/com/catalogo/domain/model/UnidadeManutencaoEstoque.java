package br.com.catalogo.domain.model;

public record UnidadeManutencaoEstoque(String codigo) {
    public UnidadeManutencaoEstoque {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("O código da Unidade de Manutenção Estoque não pode ser vazio");
        }
        // Exemplo de validação simples: UnidadeManutencaoEstoque deve ser alfanumérico
        if (!codigo.matches("^[A-Z0-9-]*$")) {
            throw new IllegalArgumentException("A Unidade de Manutenção Estoque deve conter apenas letras maiúsculas, números e hífens");
        }
    }
}
