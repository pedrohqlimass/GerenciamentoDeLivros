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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;

    @Column(unique = true)
    private String codigo;

    @Column(nullable = false, unique = false)
    private String isbn;

    @Column(name = "data_publicacao")
    private LocalDate dataPublicacao;

    @PrePersist
    public void prePersist() {
        if (this.codigo == null) {
            this.codigo = "LIV-" + UUID.randomUUID()
                    .toString()
                    .substring(0, 8)
                    .toUpperCase();
        }
    }
}