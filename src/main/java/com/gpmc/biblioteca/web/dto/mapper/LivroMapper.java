package com.gpmc.biblioteca.web.dto.mapper;

import com.gpmc.biblioteca.model.Livro;
import com.gpmc.biblioteca.web.dto.LivroCreateDto;
import org.modelmapper.ModelMapper;

public class LivroMapper {
    public static Livro toLivro(LivroCreateDto createDto){
        return new ModelMapper().map(createDto, Livro.class);
    }
}
