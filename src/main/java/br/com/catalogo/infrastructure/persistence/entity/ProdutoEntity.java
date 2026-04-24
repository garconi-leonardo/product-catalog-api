package br.com.catalogo.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "produtos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoEntity {
    
	@Id
    private UUID id;
    
    private String nome;
    private String descricao;
    
    @Column(name = "preco_valor")
    private BigDecimal precoValor;
    
    @Column(name = "preco_moeda")
    private String precoMoeda;
    
    private String unidadeManutencaoEstoque;
    
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaEntity categoria;
    
    private UUID marcaId;
    private boolean ativo;
}
