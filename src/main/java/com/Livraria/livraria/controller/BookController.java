package com.Livraria.livraria.controller;

import com.Livraria.livraria.DTOs.book.PublishBookDTO;
import com.Livraria.livraria.DTOs.book.UpdateBookDTO;
import com.Livraria.livraria.entity.BookEntity;
import com.Livraria.livraria.objectvalue.LiteraryGenreEnum;
import com.Livraria.livraria.service.book.BookService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookEntity> getAllBooks() {
        return this.bookService.getAllBooks();
    }

    @GetMapping("/filter")
    public List<BookEntity> filterByLiteraryGenre(@RequestParam(value = "gener") LiteraryGenreEnum literaryGenre) {
        return this.bookService.filterByGenre(literaryGenre);
    }

    @PostMapping
    public ResponseEntity<String> publishBook(@RequestBody PublishBookDTO book, HttpSession session) {
        String jwt = (String) session.getAttribute("jwt");
        this.bookService.CreateNewBook(book, jwt);
        return ResponseEntity.ok().body("Book posted successfully");
    }

    @PatchMapping("/{bookId}")
    public ResponseEntity<String> updatingBookInfo(@PathVariable("bookId") int id, @RequestBody UpdateBookDTO updateBookDTO) {
        this.bookService.updateBook(id, updateBookDTO);
        return ResponseEntity.ok().body("Book information successfully updated.");
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable("bookId") int id) {
        this.bookService.deleteBook(id);
        return ResponseEntity.ok().body("Book successfully deleted");
    }

}

