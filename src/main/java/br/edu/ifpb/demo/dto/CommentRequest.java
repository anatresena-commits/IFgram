package br.edu.ifpb.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CommentRequest(

        @NotBlank
        @Size(max = 500)
        String texto,

        @NotNull
        Long postId,

        @NotNull
        Long autorId

) {}

