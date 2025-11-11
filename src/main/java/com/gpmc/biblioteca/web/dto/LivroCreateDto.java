package com.gpmc.biblioteca.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LivroCreateDto {
    @NotBlank
    @Schema(example = "Frankenstein")
    private String titulo;
    @NotBlank
    @Schema(example = "Machado de Assis")
    private String autor;
    @NotBlank
    @Schema(example = "9788535910664")
    private String isbn;
    @NotBlank
    @Schema(example = "1899")
    private Integer anoPublicacao;
    @NotBlank
    @Schema(example = "10")
    private Integer quantidadeEstoque;
}
