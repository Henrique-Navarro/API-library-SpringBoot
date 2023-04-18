package com.api.library.models;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "category")
@Entity(name = "category")
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    public Category(String name) {
        this.name = name;
    }
}
