package com.Livraria.livraria.service.book;

import com.Livraria.livraria.DTOs.book.PublishBookDTO;
import com.Livraria.livraria.DTOs.book.UpdateBookDTO;
import com.Livraria.livraria.entity.BookEntity;
import com.Livraria.livraria.entity.UserEntity;
import com.Livraria.livraria.infra.Security.TokenService;
import com.Livraria.livraria.objectvalue.LiteraryGenreEnum;
import com.Livraria.livraria.repository.book.BookRepository;
import com.Livraria.livraria.repository.user.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<BookEntity> getAllBooks() {
        return this.bookRepository.getAllBooks();
    }

    public List<BookEntity> filterByGenre(LiteraryGenreEnum literaryGenreEnum) {
        return this.bookRepository.filterByGenre(literaryGenreEnum);
    }

    public void CreateNewBook(PublishBookDTO book, String token)
    {
        int id = this.bookRepository.getLastBookId();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        UserEntity user = (UserEntity) auth.getPrincipal();

        this.bookRepository.saveBook(new BookEntity(
                id,
                user.getId(),
                book.title(),
                book.description(),
                book.literaryGenre()
        ));
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
