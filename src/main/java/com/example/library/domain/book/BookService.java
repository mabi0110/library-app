package com.example.library.domain.book;

import com.example.library.domain.book.dto.BookDto;
import com.example.library.domain.book.dto.BookSaveDto;
import com.example.library.domain.category.Category;
import com.example.library.domain.category.CategoryRepository;
import com.example.library.domain.category.dto.CategoryDto;
import com.example.library.storage.FileStorageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    private final CategoryRepository categoryRepository;

    private final FileStorageService fileStorageService;

    public BookService(BookRepository bookRepository, CategoryRepository categoryRepository, FileStorageService fileStorageService) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.fileStorageService = fileStorageService;
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

    public void addBook(BookSaveDto bookSaveDto) {
        Book book = new Book();
        book.setTitle(bookSaveDto.getTitle());
        book.setDescription(bookSaveDto.getDescription());
        book.setPublisher(bookSaveDto.getPublisher());
        book.setReleaseYear(bookSaveDto.getReleaseYear());
        book.setPromoted(bookSaveDto.isPromoted());
        Category category = categoryRepository.findByNameIgnoreCase(bookSaveDto.getCategoryName()).orElseThrow();
        book.setCategory(category);
        if (bookSaveDto.getPoster() != null) {
            String savedFileName = fileStorageService.saveImage(bookSaveDto.getPoster());
            book.setPoster(savedFileName);
        }
        bookRepository.save(book);
    }
}
