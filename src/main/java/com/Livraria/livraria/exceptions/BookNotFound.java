package com.Livraria.livraria.exceptions;

public class BookNotFound extends RuntimeException {
    public BookNotFound(String message) {
        super(message);
    }

    public BookNotFound() {
        super("Nenhum livro foi encontrado");
    }
}
