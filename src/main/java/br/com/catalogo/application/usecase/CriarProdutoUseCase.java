package br.com.catalogo.application.usecase;

import br.com.catalogo.application.dto.ProdutoRequest;
import br.com.catalogo.application.dto.ProdutoResponse;
import br.com.catalogo.domain.model.Preco;
import br.com.catalogo.domain.model.Produto;
import br.com.catalogo.domain.model.UnidadeManutencaoEstoque;
import br.com.catalogo.domain.repository.ProdutoRepository;
import br.com.catalogo.infrastructure.messaging.RabbitMQPublisher;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class CriarProdutoUseCase {

    private final ProdutoRepository produtoRepository;
    private final RabbitMQPublisher publisher;

    public CriarProdutoUseCase(ProdutoRepository produtoRepository, RabbitMQPublisher publisher) {
        this.produtoRepository = produtoRepository;
        this.publisher = publisher;
    }

    public ProdutoResponse executar(ProdutoRequest request) {
    	// Transforma o DTO em Objeto de Domínio
        Produto novoProduto = new Produto(
            UUID.randomUUID(),
            request.nome(),
            request.descricao(),
            new Preco(request.preco(), request.moeda()),
            new UnidadeManutencaoEstoque(request.unidadeManutencaoEstoque()),
            null, null, true
        );

        // Salva através da interface do domínio que o Adapter implementa
        Produto produtoSalvo = produtoRepository.salvar(novoProduto);

        // Retorna o DTO de resposta
        ProdutoResponse response = new ProdutoResponse(
            produtoSalvo.getId(),
            produtoSalvo.getNome(),
            produtoSalvo.getPreco().valor(),
            produtoSalvo.getPreco().moeda(),
            produtoSalvo.getUnidadeManutencaoEstoque().codigo(),
            produtoSalvo.isAtivo()
        );

        publisher.publicarProdutoCriado(response);
        return response;
    }
}
