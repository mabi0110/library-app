package com.example.library.domain.book;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAllByPromotedIsTrue();
    List<Book> findAllByCategory_NameIgnoreCase(String name);

}
