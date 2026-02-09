package com.pedro.GerenciamentoDeLivros.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @PostMapping("/inserir")
    public String inserir() {
        return "inserir";
    }

    @GetMapping("/listar")
    public String listarLivros() {
        return "listados";
    }

    @GetMapping("/listar/{id}")
    public String listarLivrosId() {
        return "listado por id";
    }

    @PutMapping("/atualizar/{id}")
    public String atualizarLivro() {
        return "atualizado";
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarLivro() {
        System.out.println("deletado");
    }
}
