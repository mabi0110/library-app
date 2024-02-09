package com.example.library.web.admin;

import com.example.library.domain.book.BookService;
import com.example.library.domain.book.dto.BookSaveDto;
import com.example.library.domain.category.CategoryService;
import com.example.library.domain.category.dto.CategoryDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookManagementController {

    private final BookService bookService;
    private final CategoryService categoryService;

    public BookManagementController(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

    @GetMapping("/admin/add-book")
    public String addBookForm(Model model) {
        List<CategoryDto> categories = categoryService.findAllCategories();
        model.addAttribute("categories", categories);
        BookSaveDto book = new BookSaveDto();
        model.addAttribute("book", book);
        return "admin/book-form";
    }

    @PostMapping("/admin/add-book")
    public String addBook(BookSaveDto book, RedirectAttributes redirectAttributes) {
        bookService.addBook(book);
        redirectAttributes.addFlashAttribute(AdminController.NOTIFICATION_ATTRIBUTE, "Book %s was saved".formatted(book.getTitle()));
        return "redirect:/admin";
    }
}
