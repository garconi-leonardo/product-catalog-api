package br.com.catalogo.domain.model;

import br.com.catalogo.domain.model.Preco;
import br.com.catalogo.domain.model.Categoria;
import br.com.catalogo.domain.model.Marca;
import br.com.catalogo.domain.model.UnidadeManutencaoEstoque;

import java.util.UUID;

public class Produto {
    private UUID id;
    private String nome;
    private String descricao;
    private Preco preco;
    private UnidadeManutencaoEstoque unidadeManutencaoEstoque;
    private Categoria categoria;
    private Marca marca;
    private boolean ativo;

    public Produto(UUID id, String nome, String descricao, Preco preco, UnidadeManutencaoEstoque unidadeManutencaoEstoque, Categoria categoria, Marca marca, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.unidadeManutencaoEstoque = unidadeManutencaoEstoque;
        this.categoria = categoria;
        this.marca = marca;
        this.ativo = ativo;
    }

    public void atualizarPreco(Preco novoPreco) {
        this.preco = novoPreco;
    }

    // Getters e Setters
    public UUID getId() { return id; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public Preco getPreco() { return preco; }
    public UnidadeManutencaoEstoque getUnidadeManutencaoEstoque() { return unidadeManutencaoEstoque; }
    public Categoria getCategoria() { return categoria; }
    public Marca getMarca() { return marca; }
    public boolean isAtivo() { return ativo; }
}
