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
    private Integer anoPublicacao;
    private Integer quantidadeEstoque;
}
