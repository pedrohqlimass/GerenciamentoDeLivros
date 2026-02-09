package com.pedro.GerenciamentoDeLivros.service;

import com.pedro.GerenciamentoDeLivros.model.LivroModel;
import com.pedro.GerenciamentoDeLivros.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public List<LivroModel> listarLivros() {
        return repository.findAll();
    }

    public LivroModel listarLivroId(Long id) {
        Optional<LivroModel> livro = repository.findById(id);
        return livro.orElse(null);
    }
}
