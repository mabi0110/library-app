package com.example.library.web;

import com.example.library.domain.book.BookService;
import com.example.library.domain.book.dto.BookDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final BookService bookService;

    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String home(Model model){
        List<BookDto> promotedBooks = bookService.findAllPromotedBooks();
        model.addAttribute("heading", "Promoted books");
        model.addAttribute("description", "Books recommended by users");
        model.addAttribute("books", promotedBooks);
        return "book-listing";
    }

}
