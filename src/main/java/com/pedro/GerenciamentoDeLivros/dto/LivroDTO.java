package com.pedro.GerenciamentoDeLivros.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO {

    private Long id;

    private String titulo;
    private String autor;
    private String codigo;
    private String isbn;

    private LocalDate dataPublicacao;
}
