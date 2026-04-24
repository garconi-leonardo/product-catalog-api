package br.com.catalogo.domain.exception;

import java.util.UUID;

public class ProdutoNaoEncontradoException extends RuntimeException {
    public ProdutoNaoEncontradoException(UUID id) {
        super("Produto com ID " + id + " não foi encontrado.");
    }
}
