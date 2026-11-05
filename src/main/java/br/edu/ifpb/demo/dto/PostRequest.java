package br.edu.ifpb.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PostRequest(

        @NotBlank
        String imagemUrl,

        @Size(max = 300)
        String legenda,

        @NotNull
        Long autorId

) {}
