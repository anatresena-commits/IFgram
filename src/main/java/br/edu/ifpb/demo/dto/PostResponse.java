package br.edu.ifpb.demo.dto;

import br.edu.ifpb.demo.model.Post;

import java.time.LocalDateTime;

public record PostResponse(
        Long id,
        String imagemUrl,
        String legenda,
        LocalDateTime criadoEm,
        Long autorId,
        String autorNome
) {

    public static PostResponse from(Post post) {
        return new PostResponse(
                post.getId(),
                post.getImagemUrl(),
                post.getLegenda(),
                post.getCriadoEm(),
                post.getAutor().getId(),
                post.getAutor().getNome()
        );
    }
}

