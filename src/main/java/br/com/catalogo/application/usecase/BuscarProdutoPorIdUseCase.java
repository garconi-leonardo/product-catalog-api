package br.com.catalogo.application.usecase;

import br.com.catalogo.application.dto.ProdutoResponse;

import br.com.catalogo.domain.exception.ProdutoNaoEncontradoException;
import br.com.catalogo.domain.model.Produto;
import br.com.catalogo.domain.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class BuscarProdutoPorIdUseCase {

    private final ProdutoRepository produtoRepository;

    public BuscarProdutoPorIdUseCase(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoResponse executar(UUID id) {
        Produto produto = produtoRepository.buscarPorId(id)
                .orElseThrow(() -> new ProdutoNaoEncontradoException(id));

        return new ProdutoResponse(
            produto.getId(),
            produto.getNome(),
            produto.getPreco().valor(),
            produto.getPreco().moeda(),
            produto.getUnidadeManutencaoEstoque().codigo(),
            produto.isAtivo()
        );
    }
}
