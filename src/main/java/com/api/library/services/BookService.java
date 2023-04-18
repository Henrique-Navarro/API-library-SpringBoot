package com.api.library.services;

import com.api.library.models.Author;
import com.api.library.models.Book;
import com.api.library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public void save(Book book) {
        this.bookRepository.save(book);
    }

    public List<Book> getBookList() {
        return this.bookRepository.findAll();
    }

    public Book findById(Long id) {
        return this.bookRepository.findById(id).get();
    }
    
    public List<Book> searchByName(String name){
        return this.bookRepository.findByNameContains(name);
    }
    
    public void delete(Long id){
        this.bookRepository.deleteById(id);
    }
    
}
