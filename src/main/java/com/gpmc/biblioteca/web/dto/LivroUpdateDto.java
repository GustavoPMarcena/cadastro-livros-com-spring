package com.gpmc.biblioteca.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LivroUpdateDto {
    private String titulo;
    private String autor;
    private String isbn;
    private int anoPublicacao;
    private int quantidadeEstoque;
}
