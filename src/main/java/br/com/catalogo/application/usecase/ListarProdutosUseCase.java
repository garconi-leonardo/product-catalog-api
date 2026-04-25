package br.com.catalogo.application.usecase;

import br.com.catalogo.application.dto.ProdutoResponse;
import br.com.catalogo.domain.repository.ProdutoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarProdutosUseCase {

    private final ProdutoRepository produtoRepository;

    public ListarProdutosUseCase(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Page<ProdutoResponse> executar(Pageable pageable) {
        return produtoRepository.listarTodos(pageable)
                .map(p -> new ProdutoResponse(
                    p.getId(), p.getNome(), p.getPreco().valor(), 
                    p.getPreco().moeda(), p.getUnidadeManutencaoEstoque().codigo(), p.isAtivo()
                ));
    }
}

