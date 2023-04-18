package com.api.library.services;

import com.api.library.models.Author;
import com.api.library.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Classe que implementa as regras de negócio*/
@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;     //injeção de dependência

    public List<Author> getAuthorList() {
        return Streamable.of(this.authorRepository.findAll()).toList();
    }

}
