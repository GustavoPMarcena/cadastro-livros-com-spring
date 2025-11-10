package com.gpmc.biblioteca.repository;

import com.gpmc.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BibliotecaRepository extends JpaRepository<Livro, Long> {
    Optional<Livro> findByIsbn(String isbn);
    Boolean existsByIsbn(String isbn);
}
