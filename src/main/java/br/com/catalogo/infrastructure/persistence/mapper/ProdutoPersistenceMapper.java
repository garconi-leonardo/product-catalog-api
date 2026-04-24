package br.com.catalogo.infrastructure.persistence.mapper;

import br.com.catalogo.infrastructure.persistence.entity.ProdutoEntity;
import br.com.catalogo.domain.model.Preco;
import br.com.catalogo.domain.model.Produto;
import br.com.catalogo.domain.model.UnidadeManutencaoEstoque;
import br.com.catalogo.infrastructure.persistence.entity.CategoriaEntity;
import org.springframework.stereotype.Component;

@Component
public class ProdutoPersistenceMapper {

    public ProdutoEntity paraEntidade(Produto produto) {
        if (produto == null) return null;
        
        CategoriaEntity categoriaEntity = null;
        if (produto.getCategoria() != null) {
            categoriaEntity = new CategoriaEntity(
                produto.getCategoria().getId(),
                produto.getCategoria().getNome(),
                produto.getCategoria().isAtivo()
            );
        }

        return new ProdutoEntity(
            produto.getId(),
            produto.getNome(),
            produto.getDescricao(),
            produto.getPreco().valor(),
            produto.getPreco().moeda(),
            produto.getUnidadeManutencaoEstoque().codigo(),
            categoriaEntity,
            produto.getMarca() != null ? produto.getMarca().getId() : null,
            produto.isAtivo()
        );
    }

    public Produto paraDominio(ProdutoEntity entidade) {
        if (entidade == null) return null;

        return new Produto(
            entidade.getId(),
            entidade.getNome(),
            entidade.getDescricao(),
            new Preco(entidade.getPrecoValor(), entidade.getPrecoMoeda()),
            new UnidadeManutencaoEstoque(entidade.getUnidadeManutencaoEstoque()),
            null, // Categoria e Marca
            null,
            entidade.isAtivo()
        );
    }
    
}
