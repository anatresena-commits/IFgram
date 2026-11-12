
package br.edu.ifpb.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest(

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Size(min = 3)
        String nome,

        @NotBlank
        @Size(min = 4)
        String senha

) {
}
