package br.com.catalogo.domain.exception;

public class PrecoInvalidoException extends RuntimeException {
    public PrecoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
