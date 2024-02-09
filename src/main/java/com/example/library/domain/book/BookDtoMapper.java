package com.example.library.domain.book;

import com.example.library.domain.book.dto.BookDto;

public class BookDtoMapper {

    static BookDto map(Book book){
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getDescription(),
                book.getPublisher(),
                book.getReleaseYear(),
                book.isPromoted(),
                book.getPoster(),
                book.getCategory().getName()
        );
    }
}
