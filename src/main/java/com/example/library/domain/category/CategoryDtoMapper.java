package com.example.library.domain.category;

import com.example.library.domain.category.dto.CategoryDto;

public class CategoryDtoMapper {

    static CategoryDto map(Category category) {
        return new CategoryDto(
                category.getId(),
                category.getName(),
                category.getDescription());
    }
}
