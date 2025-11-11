package com.gpmc.biblioteca;

import com.gpmc.biblioteca.model.Livro;
import com.gpmc.biblioteca.service.BibliotecaService;
import com.gpmc.biblioteca.web.controller.BibliotecaController;
import com.gpmc.biblioteca.web.dto.LivroCreateDto;
import com.gpmc.biblioteca.web.dto.LivroUpdateDto;
import com.gpmc.biblioteca.web.dto.PageableDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BibliotecaTest {
    @Mock
    private BibliotecaService bibliotecaService;

    @InjectMocks
    private BibliotecaController bibliotecaController;

    private Livro livro;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        livro = new Livro();
        livro.setId(1L);
        livro.setTitulo("Frankenstein");
        livro.setAutor("Machado de Assis");
        livro.setIsbn("1234567890");
        livro.setAnoPublicacao(1899);
        livro.setQuantidadeEstoque(10);
    }

    @Test
    void deveCriarLivro() {
        LivroCreateDto createDto = new LivroCreateDto();
        createDto.setTitulo("Dom Casmurro");
        createDto.setAutor("Machado de Assis");
        createDto.setIsbn("1234567890");
        createDto.setAnoPublicacao(1899);
        createDto.setQuantidadeEstoque(10);

        when(bibliotecaService.salvarLivro(any(Livro.class))).thenReturn(livro);


        ResponseEntity<Livro> response = bibliotecaController.criarLivro(createDto);


        assertEquals(201, response.getStatusCodeValue());
        assertEquals(livro, response.getBody());
        verify(bibliotecaService, times(1)).salvarLivro(any(Livro.class));
    }

    @Test
    void deveListarLivrosComPaginacao() {

        Pageable pageable = PageRequest.of(0, 10);
        Page<Livro> page = new PageImpl<>(List.of(livro));
        when(bibliotecaService.listarLivros(any(PageRequest.class))).thenReturn(page);

        ResponseEntity<PageableDto> response = bibliotecaController.getAllLivros(pageable);

        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        verify(bibliotecaService, times(1)).listarLivros(any(PageRequest.class));
    }

    @Test
    void deveBuscarLivroPorId() {
        when(bibliotecaService.buscarPorId(1L)).thenReturn(livro);

        ResponseEntity<Livro> response = bibliotecaController.buscarLivroPorId(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(livro, response.getBody());
        verify(bibliotecaService, times(1)).buscarPorId(1L);
    }

    @Test
    void deveBuscarLivroPorIsbn() {
        when(bibliotecaService.buscarPorIsbn("1234567890")).thenReturn(livro);


        ResponseEntity<Livro> response = bibliotecaController.buscarLivroPorIsbn("1234567890");

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(livro, response.getBody());
        verify(bibliotecaService, times(1)).buscarPorIsbn("1234567890");
    }

    @Test
    void deveAtualizarLivro() {

        LivroUpdateDto dto = new LivroUpdateDto();
        dto.setTitulo("Dom Casmurro - Edição Revisada");

        when(bibliotecaService.atualizarLivro(eq(1L), any(LivroUpdateDto.class))).thenReturn(livro);


        ResponseEntity<Livro> response = bibliotecaController.atualizarLivro(1L, dto);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(livro, response.getBody());
        verify(bibliotecaService, times(1)).atualizarLivro(eq(1L), any(LivroUpdateDto.class));
    }

    @Test
    void deveDeletarLivro() {

        ResponseEntity<Void> response = bibliotecaController.deletarLivroPorId(1L);

        assertEquals(204, response.getStatusCodeValue());
        verify(bibliotecaService, times(1)).deletarLivro(1L);
    }
}
