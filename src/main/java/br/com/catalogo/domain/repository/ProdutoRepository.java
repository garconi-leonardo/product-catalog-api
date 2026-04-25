package br.com.catalogo.domain.repository;

import br.com.catalogo.domain.model.Produto;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface ProdutoRepository {
    Produto salvar(Produto produto);
    Optional<Produto> buscarPorId(UUID id);
    void deletar(UUID id);
 // listagem paginada
    Page<Produto> listarTodos(Pageable pageable);
}
