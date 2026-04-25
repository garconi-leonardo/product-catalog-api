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

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Preco getPreco() {
		return preco;
	}

	public void setPreco(Preco preco) {
		this.preco = preco;
	}

	public UnidadeManutencaoEstoque getUnidadeManutencaoEstoque() {
		return unidadeManutencaoEstoque;
	}

	public void setUnidadeManutencaoEstoque(UnidadeManutencaoEstoque unidadeManutencaoEstoque) {
		this.unidadeManutencaoEstoque = unidadeManutencaoEstoque;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}    
}
