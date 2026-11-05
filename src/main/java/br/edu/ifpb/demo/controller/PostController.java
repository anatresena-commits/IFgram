package br.edu.ifpb.demo.controller;

import br.edu.ifpb.demo.dto.PostRequest;
import br.edu.ifpb.demo.dto.PostResponse;
import br.edu.ifpb.demo.service.PostService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // Listar feed
    @GetMapping
    public List<PostResponse> listarFeed() {
        return postService.listarFeed();
    }

    // Buscar post pelo ID
    @GetMapping("/{id}")
    public PostResponse buscarPorId(@PathVariable Long id) {
        return postService.buscarPorId(id);
    }

    // Listar posts de um usuário
    @GetMapping("/autor/{autorId}")
    public List<PostResponse> listarPorAutor(
            @PathVariable Long autorId) {
        return postService.listarPorAutor(autorId);
    }

    // Criar post
    @PostMapping
    public PostResponse criar(@Valid @RequestBody PostRequest request) {
        return postService.criar(request);
    }

    // Deletar post
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        postService.deletar(id);
    }
}

