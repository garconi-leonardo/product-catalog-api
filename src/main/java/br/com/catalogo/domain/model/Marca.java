package br.com.catalogo.domain.model;

import java.util.UUID;

public class Marca {
    private UUID id;
    private String nome;

    public Marca(UUID id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters e Setters
    public UUID getId() { return id; }
    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }
}
