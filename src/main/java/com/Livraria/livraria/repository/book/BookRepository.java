package com.Livraria.livraria.repository.book;

import com.Livraria.livraria.entity.BookEntity;
import com.Livraria.livraria.objectvalue.LiteraryGenreEnum;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class BookRepository {
    List<BookEntity> books = new LinkedList<>();

    public void saveBook(BookEntity book) {
        this.books.add(book);
    }

    public List<BookEntity> getAllBooks() {
        return this.books;
    }

    public int getLastBookId() {
        return books.isEmpty() ? 1 : books.getLast().getId() + 1;
    }

    public BookEntity getBookById(int id) {
        return this.books.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }

    public void deleteBook(int id) {
        this.books.removeIf(x -> x.getId() == id);
    }

    public List<BookEntity> filterByGenre(LiteraryGenreEnum literaryGenre) {
        return this.books.stream().filter(x -> x.getLiteraryGenre() == literaryGenre).toList();
    }

}
