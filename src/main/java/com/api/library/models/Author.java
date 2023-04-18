package com.api.library.models;

import jakarta.persistence.*;
import lombok.*;

/**
 * cria uma tabela com o nome author
 *
 * @@Table: entidade usada pelo spring boot
 * @@Entity: representa uma tabela no banco de dados
 */
@Table(name = "author")
@Entity(name = "author")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "nationality")
    private String nationality;

    public Author(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

}
