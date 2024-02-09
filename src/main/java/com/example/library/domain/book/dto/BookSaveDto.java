package com.example.library.domain.book.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookSaveDto {
    private String title;
    private String description;
    private String publisher;
    private Integer releaseYear;
    private boolean promoted;
    private MultipartFile poster;
    private String categoryName;
}
