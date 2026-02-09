package com.pedro.GerenciamentoDeLivros.repository;

import com.pedro.GerenciamentoDeLivros.model.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroModel, Long> {
}
