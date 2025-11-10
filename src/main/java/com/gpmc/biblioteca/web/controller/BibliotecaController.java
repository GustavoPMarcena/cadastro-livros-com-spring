package com.gpmc.biblioteca.web.controller;

import com.gpmc.biblioteca.model.Livro;
import com.gpmc.biblioteca.service.BibliotecaService;
import com.gpmc.biblioteca.web.dto.LivroCreateDto;
import com.gpmc.biblioteca.web.dto.LivroUpdateDto;
import com.gpmc.biblioteca.web.dto.PageableDto;
import com.gpmc.biblioteca.web.dto.mapper.LivroMapper;
import com.gpmc.biblioteca.web.dto.mapper.PageableMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/biblioteca")
@Tag(name = "Biblioteca", description = "CRUD para métodos de uma biblioteca")
public class BibliotecaController {
    private final BibliotecaService bibliotecaService;

    @PostMapping
    public ResponseEntity<Livro> criarLivro(@RequestBody LivroCreateDto createDto) {
        Livro livro = bibliotecaService.salvarLivro(LivroMapper.toLivro(createDto));
        return ResponseEntity.status(201).body(livro);
    }

    @GetMapping
    public ResponseEntity<PageableDto> getAllLivros(Pageable pageable) {
        Page<Livro> livros = bibliotecaService.listarLivros(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()));
        return ResponseEntity.status(200).body(PageableMapper.toDto(livros));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarLivroPorId(@PathVariable Long id) {
        Livro livro = bibliotecaService.buscarPorId(id);
        return ResponseEntity.status(200).body(livro);
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Livro> buscarLivroPorIsbn(@PathVariable String isbn) {
        Livro livro = bibliotecaService.buscarPorIsbn(isbn);
        return ResponseEntity.status(200).body(livro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable Long id, @RequestBody LivroUpdateDto dto) {
        Livro livro = bibliotecaService.atualizarLivro(id, dto);
        return ResponseEntity.status(200).body(livro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivroPorId(@PathVariable Long id) {
        bibliotecaService.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }
}
