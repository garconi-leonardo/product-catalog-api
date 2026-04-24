package br.com.catalogo.application.usecase;

import br.com.catalogo.application.dto.ProdutoRequest;
import br.com.catalogo.application.dto.ProdutoResponse;
import br.com.catalogo.domain.model.Preco;
import br.com.catalogo.domain.model.Produto;
import br.com.catalogo.domain.model.UnidadeManutencaoEstoque;
import br.com.catalogo.domain.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class CriarProdutoUseCase {

    private final ProdutoRepository produtoRepository;

    public CriarProdutoUseCase(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoResponse executar(ProdutoRequest request) {
        // Transforma o DTO em Objeto de Domínio
        Produto novoProduto = new Produto(
            UUID.randomUUID(),
            request.nome(),
            request.descricao(),
            new Preco(request.preco(), request.moeda()),
            new UnidadeManutencaoEstoque(request.unidadeManutencaoEstoque()),
            null, // Categoria e marca
            null,
            true
        );

        // Salva através da interface do domínio que o Adapter implementa
        Produto produtoSalvo = produtoRepository.salvar(novoProduto);

        // 3. Retorna o DTO de resposta
        return new ProdutoResponse(
            produtoSalvo.getId(),
            produtoSalvo.getNome(),
            produtoSalvo.getPreco().valor(),
            produtoSalvo.getPreco().moeda(),
            produtoSalvo.getUnidadeManutencaoEstoque().codigo(),
            produtoSalvo.isAtivo()
        );
    }
}
