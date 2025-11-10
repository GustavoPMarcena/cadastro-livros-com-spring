package com.gpmc.biblioteca.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LivroCreateDto {
    @NotBlank
    private String titulo;
    @NotBlank
    private String autor;
    @NotBlank
    private String isbn;
    @NotBlank
    private int anoPublicacao;
    @NotBlank
    private int quantidadeEstoque;
}
