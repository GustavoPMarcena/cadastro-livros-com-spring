package com.gpmc.biblioteca.model;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString @Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String autor;
    @Column(nullable = false, unique = true)
    private String isbn;
    @Column(nullable = false)
    private int anoPublicacao;
    @Column(nullable = false)
    private int quantidadeEstoque;
}
