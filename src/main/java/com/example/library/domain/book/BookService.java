package com.example.library.domain.book;

import com.example.library.domain.book.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDto> findAllPromotedBooks() {
        return bookRepository.findAllByPromotedIsTrue().stream()
                .map(BookDtoMapper::map)
                .toList();
    }

    public Optional<BookDto> findBookById(Long id){
        return bookRepository.findById(id).map(BookDtoMapper::map);
    }

    public List<BookDto> findBooksByCategoryName(String name) {
        return bookRepository.findAllByCategory_NameIgnoreCase(name).stream()
                .map(BookDtoMapper::map)
                .toList();
    }
}
