package br.edu.ifpb.demo.controller;

import br.edu.ifpb.demo.dto.CommentRequest;
import br.edu.ifpb.demo.dto.CommentResponse;
import br.edu.ifpb.demo.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // Criar comentário
    @PostMapping
    public CommentResponse criar(
            @Valid @RequestBody CommentRequest request) {
        return commentService.criar(request);
    }

    // Listar comentários de um post
    @GetMapping("/post/{postId}")
    public List<CommentResponse> listarPorPost(
            @PathVariable Long postId) {
        return commentService.listarPorPost(postId);
    }

    // Deletar comentário
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        commentService.deletar(id);
    }
}


