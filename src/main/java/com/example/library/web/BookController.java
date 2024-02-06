package com.example.library.web;

import com.example.library.domain.book.BookService;
import com.example.library.domain.book.dto.BookDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book/{id}")
    public String getBook(@PathVariable long id, Model model) {
        Optional<BookDto> optionalBook = bookService.findBookById(id);
        optionalBook.ifPresent(book -> model.addAttribute("book", book));
        return "book";

    }
}
