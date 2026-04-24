package br.com.catalogo.infrastructure.persistence.repository;

import br.com.catalogo.infrastructure.persistence.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface JpaProdutoRepository extends JpaRepository<ProdutoEntity, UUID> {
    // métodos de busca
}
