package com.pedro.GerenciamentoDeLivros.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_livros")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String titulo;
    private String autor;
    private String codigo;

    @Column(nullable = false, unique = false)
    private String isbn;

    @Column(name = "data_publicacao")
    private LocalDate dataPublicacao;

    @PrePersist
    public void gerarCodigo() {
        this.codigo = "LIV-" + UUID.randomUUID()
                .toString()
                .substring(0,8)
                .toUpperCase();
    }

}
