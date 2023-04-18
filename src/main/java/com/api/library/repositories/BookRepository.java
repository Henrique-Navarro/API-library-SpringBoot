package com.api.library.repositories;

import com.api.library.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Override
    List<Book>findAll();
    
    List<Book>findByNameContains(String name);
}
