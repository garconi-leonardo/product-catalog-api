package br.com.catalogo.domain.repository;

import br.com.catalogo.domain.model.Produto;

import java.util.Optional;
import java.util.UUID;

public interface ProdutoRepository {
    Produto salvar(Produto produto);
    Optional<Produto> buscarPorId(UUID id);
    void deletar(UUID id);
}
