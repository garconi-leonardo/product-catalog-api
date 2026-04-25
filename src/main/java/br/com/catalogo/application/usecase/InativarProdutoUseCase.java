package br.com.catalogo.application.usecase;

import br.com.catalogo.domain.exception.ProdutoNaoEncontradoException;
import br.com.catalogo.domain.model.Produto;
import br.com.catalogo.domain.repository.ProdutoRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
public class InativarProdutoUseCase {

    private final ProdutoRepository produtoRepository;

    public InativarProdutoUseCase(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Transactional
    @CacheEvict(value = "produtos", key = "#id")
    public void executar(UUID id) {
        Produto produto = produtoRepository.buscarPorId(id)
                .orElseThrow(() -> new ProdutoNaoEncontradoException(id));

        produto.setAtivo(false);
        produtoRepository.salvar(produto);
    }
}

