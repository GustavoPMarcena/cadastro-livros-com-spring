package com.gpmc.biblioteca.service;

import com.gpmc.biblioteca.exception.ResourceNotFoundException;
import com.gpmc.biblioteca.model.Livro;
import com.gpmc.biblioteca.repository.BibliotecaRepository;
import com.gpmc.biblioteca.web.dto.LivroUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BibliotecaService {
    private final BibliotecaRepository bibliotecaRepository;

    @Transactional
    public Livro salvarLivro(Livro livro) {
        return bibliotecaRepository.save(livro);
    }

    @Transactional(readOnly = true)
    public Page<Livro> listarLivros(Pageable pageable) {
        return bibliotecaRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Livro buscarPorId(Long id) {
        return bibliotecaRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Livro não encontrado"));
    }

    @Transactional(readOnly = true)
    public Livro buscarPorIsbn(String isbn) {
        return bibliotecaRepository.findByIsbn(isbn).orElseThrow(() ->
                new ResourceNotFoundException("Livro não encontrado"));
    }

    @Transactional
    public Livro atualizarLivro(Long id, LivroUpdateDto livroUpdateDto) {
        Livro livroExistente = buscarPorId(id);
        handleAtualizacaoLivro(livroExistente, livroUpdateDto);
        return salvarLivro(livroExistente);
    }

    @Transactional
    public void deletarLivro(Long id) {
        bibliotecaRepository.delete(buscarPorId(id));
    }

    private void handleAtualizacaoLivro(Livro livro, LivroUpdateDto livroUpdateDto) {
        if (livroUpdateDto.getTitulo() != null) livro.setTitulo(livroUpdateDto.getTitulo());
        if (livroUpdateDto.getAutor() != null) livro.setAutor(livroUpdateDto.getAutor());
        if (livroUpdateDto.getAnoPublicacao() != livro.getAnoPublicacao()) livro.setAnoPublicacao(livroUpdateDto.getAnoPublicacao());
        if (livroUpdateDto.getQuantidadeEstoque() != livro.getQuantidadeEstoque()) livro.setQuantidadeEstoque(livroUpdateDto.getQuantidadeEstoque());

        if(livroUpdateDto.getIsbn() != null && !bibliotecaRepository.existsByIsbn(livro.getIsbn())) {
            livro.setIsbn(livroUpdateDto.getIsbn());
        }
    }
}
