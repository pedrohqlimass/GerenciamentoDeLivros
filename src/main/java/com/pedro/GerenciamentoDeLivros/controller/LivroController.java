package com.pedro.GerenciamentoDeLivros.controller;

import com.pedro.GerenciamentoDeLivros.model.LivroModel;
import com.pedro.GerenciamentoDeLivros.service.LivroService;
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
    public String inserir() {
        return "inserir";
    }

    @GetMapping("/listar")
    public List<LivroModel> listarLivros() {
        return service.listarLivros();
    }

    @GetMapping("/listar/{id}")
    public LivroModel listarLivroId(@PathVariable Long id) {
        return service.listarLivroId(id);
    }

    @PutMapping("/atualizar/{id}")
    public LivroModel atualizarLivro(@PathVariable Long id, @RequestBody LivroModel livroAtualizado) {
        return service.atualizarLivro(id, livroAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarLivro() {
        System.out.println("deletado");
    }
}
