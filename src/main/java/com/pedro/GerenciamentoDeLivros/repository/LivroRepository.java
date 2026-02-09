package com.pedro.GerenciamentoDeLivros.repository;

import com.pedro.GerenciamentoDeLivros.model.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LivroRepository extends JpaRepository<LivroModel, UUID> {
}
