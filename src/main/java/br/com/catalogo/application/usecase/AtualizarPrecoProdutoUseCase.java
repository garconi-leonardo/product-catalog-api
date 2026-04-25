package br.com.catalogo.application.usecase;

import br.com.catalogo.application.dto.ProdutoResponse;

import br.com.catalogo.domain.exception.ProdutoNaoEncontradoException;
import br.com.catalogo.domain.model.Preco;
import br.com.catalogo.domain.model.Produto;
import br.com.catalogo.domain.repository.ProdutoRepository;
import br.com.catalogo.infrastructure.messaging.RabbitMQPublisher;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.UUID;

@Service
public class AtualizarPrecoProdutoUseCase {

    private final ProdutoRepository produtoRepository;
    private final RabbitMQPublisher publisher;

    public AtualizarPrecoProdutoUseCase(ProdutoRepository produtoRepository, RabbitMQPublisher publisher) {
        this.produtoRepository = produtoRepository;
        this.publisher = publisher;
    }

    @Transactional
    @CacheEvict(value = "produtos", key = "#id") // Limpa o cache do produto ao mudar o preço
    public ProdutoResponse executar(UUID id, BigDecimal novoValor, String moeda) {
        
        Produto produto = produtoRepository.buscarPorId(id)
                .orElseThrow(() -> new ProdutoNaoEncontradoException(id));

        //Atualiza o preço
        produto.atualizarPreco(new Preco(novoValor, moeda));

        Produto produtoAtualizado = produtoRepository.salvar(produto);

        ProdutoResponse response = new ProdutoResponse(
            produtoAtualizado.getId(),
            produtoAtualizado.getNome(),
            produtoAtualizado.getPreco().valor(),
            produtoAtualizado.getPreco().moeda(),
            produtoAtualizado.getUnidadeManutencaoEstoque().codigo(),
            produtoAtualizado.isAtivo()
        );

        // Notifica o RabbitMQ (Evento de alteração de preço)
        publisher.publicarProdutoCriado(response);
        
        System.out.println("novoValor: " + novoValor);
        
        return response;
    }
}
