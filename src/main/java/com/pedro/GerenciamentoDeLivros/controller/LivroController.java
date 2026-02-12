package com.pedro.GerenciamentoDeLivros.controller;

import com.pedro.GerenciamentoDeLivros.dto.LivroDTO;
import com.pedro.GerenciamentoDeLivros.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @PostMapping("/inserir")
    public ResponseEntity<String> inserirLivro(@RequestBody LivroDTO model) {

        LivroDTO novoLivro = service.inserirLivro(model);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Livro inserido com sucesso no id: " + novoLivro.getId());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<LivroDTO>> listarLivros() {

        List<LivroDTO> dtos = service.listarLivros();

        if (dtos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarLivroId(@PathVariable Long id) {

        LivroDTO dto = service.listarLivroId(id);

        if (dto != null) {
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Livro com o ID " + id + " não existe nos nossos resgistros.");
        }

    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarLivroPorId(@PathVariable Long id, @RequestBody LivroDTO livroAtualizado) {

        if (service.listarLivroId(id) != null) {
            service.atualizarLivro(id, livroAtualizado);
            return ResponseEntity.ok("Livro de ID " + id + " foi alterado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Livro com o ID " + id + " não existe nos nossos resgistros.");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarLivro(@PathVariable Long id) {

        if (service.listarLivroId(id) != null) {
            service.deletarLivro(id);
            return ResponseEntity.ok("Livro com o ID " + id + " deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Livro com o ID " + id + " não existe nos nossos registros.");
        }
    }
}
