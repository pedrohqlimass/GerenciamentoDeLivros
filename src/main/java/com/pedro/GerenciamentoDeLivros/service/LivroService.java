package com.pedro.GerenciamentoDeLivros.service;

import com.pedro.GerenciamentoDeLivros.dto.LivroDTO;
import com.pedro.GerenciamentoDeLivros.mapper.LivroMapper;
import com.pedro.GerenciamentoDeLivros.model.LivroModel;
import com.pedro.GerenciamentoDeLivros.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private LivroRepository repository;
    private LivroMapper mapper;

    public LivroService(LivroRepository repository, LivroMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public LivroDTO inserirLivro(LivroDTO dto) {
        LivroModel model = mapper.toModel(dto);
        return mapper.toDTO(repository.save(model));
    }

    public List<LivroDTO> listarLivros() {
        return mapper.toDTOList(repository.findAll());
    }

    public LivroDTO listarLivroId(Long id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElse(null);
    }

    public LivroDTO atualizarLivro(Long id, LivroDTO dto) {
        return repository.findById(id)
                .map(livroExistente -> {
                    LivroModel livroAtualizado = mapper.toModel(dto);
                    livroAtualizado.setId(id);
                    return mapper.toDTO(repository.save(livroAtualizado));
                })
                .orElse(null);
    }

    public void deletarLivro(Long id) {
        repository.deleteById(id);
    }
}
