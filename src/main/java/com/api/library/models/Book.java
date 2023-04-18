package com.api.library.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;

/**
 * Cria uma tabela chamada book
 */
@Entity(name = "book")
@Table(name = "book")
@Getter                  /*Gera automaticamente todos os getters*/
@Setter                  /*Gera automaticamente todos os setters*/
@Data                    /*Gera automaticamente todos os métodos úteis*/
@AllArgsConstructor      /*Gera construtor com todos os parâmetros*/
@NoArgsConstructor       /*Gera construtor sem nenhum parâmetro*/
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    
    public Book(String name, Category category, Author author) {
        this.name = name;
        this.category = category;
        this.author = author;
    }
}
