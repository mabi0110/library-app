package com.example.library.domain.book.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookDto {

    private Long id;
    private String title;
    private String description;
    private String publisher;
    private Integer releaseYear;
    private boolean promoted;
    private String categoryName;

}
