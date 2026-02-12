package com.pedro.GerenciamentoDeLivros.mapper;

import com.pedro.GerenciamentoDeLivros.dto.LivroDTO;
import com.pedro.GerenciamentoDeLivros.model.LivroModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LivroMapper {

    public LivroModel toModel(LivroDTO dto) {
        if (dto == null) return null;

        LivroModel model = new LivroModel();
        model.setId(dto.getId());
        model.setTitulo(dto.getTitulo());
        model.setAutor(dto.getAutor());
        model.setCodigo(dto.getCodigo());
        model.setIsbn(dto.getIsbn());
        model.setDataPublicacao(dto.getDataPublicacao());

        return model;
    }

    public LivroDTO toDTO(LivroModel model) {
        if (model == null) return null;

        LivroDTO dto = new LivroDTO();
        dto.setId(model.getId());
        dto.setTitulo(model.getTitulo());
        dto.setAutor(model.getAutor());
        dto.setCodigo(model.getCodigo());
        dto.setIsbn(model.getIsbn());
        dto.setDataPublicacao(model.getDataPublicacao());

        return dto;
    }

    public List<LivroDTO> toDTOList(List<LivroModel> models) {
        if (models == null) return List.of();

        return models.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<LivroModel> toModelList(List<LivroDTO> dtos) {
        if (dtos == null) return List.of();

        return dtos.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}
