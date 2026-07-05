package com.Livraria.livraria.controller;

import com.Livraria.livraria.DTOs.PublishBookDTO;
import com.Livraria.livraria.DTOs.UpdateBookDTO;
import com.Livraria.livraria.entity.BookEntity;
import com.Livraria.livraria.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookEntity> getAllBooks() {
        return this.bookService.getAllBooks();
    }

    @PostMapping
    public ResponseEntity<String> publishBook(@RequestBody PublishBookDTO book) {
        this.bookService.CreateNewBook(book);
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
