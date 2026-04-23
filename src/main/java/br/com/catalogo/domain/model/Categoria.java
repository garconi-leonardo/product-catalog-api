package br.com.catalogo.domain.model;

import java.util.UUID;

public class Categoria {
    private UUID id;
    private String nome;
    private boolean ativo;

    public Categoria(UUID id, String nome, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.ativo = ativo;
    }

    // Getters e Setters
    public UUID getId() { return id; }
    public String getNome() { return nome; }
    public boolean isAtivo() { return ativo; }
    
    public void setNome(String nome) { this.nome = nome; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
}
