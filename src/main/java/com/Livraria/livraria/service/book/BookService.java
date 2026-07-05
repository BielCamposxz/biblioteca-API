package com.Livraria.livraria.service.book;

import com.Livraria.livraria.DTOs.PublishBookDTO;
import com.Livraria.livraria.DTOs.UpdateBookDTO;
import com.Livraria.livraria.entity.BookEntity;
import com.Livraria.livraria.repository.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void CreateNewBook(PublishBookDTO book)
    {
        int id = this.bookRepository.getLastUserId();
        int authorId = 1;
        this.bookRepository.saveBook(new BookEntity(
                id,
                authorId,
                book.title(),
                book.description(),
                book.literaryGenre()
        ));
    }

    public List<BookEntity> getAllBooks() {
        return this.bookRepository.getAllBooks();
    }

    public void deleteBook(int id) {
        this.bookRepository.deleteBook(id);
    }

    public void updateBook(int id, UpdateBookDTO updateBookDTO) {
        BookEntity book = bookRepository.getBookById(id);

        // retornar uma exception no futuro
        if(book == null) return;
        if(updateBookDTO.literaryGenre() != null) book.setLiteraryGenre(updateBookDTO.literaryGenre());
        if(updateBookDTO.description() != null) book.setDescription(updateBookDTO.description());
        if(updateBookDTO.title() != null) book.setTitle(updateBookDTO.title());

    }

}
