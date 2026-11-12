
package br.edu.ifpb.demo.controller;

import br.edu.ifpb.demo.dto.UserRequest;
import br.edu.ifpb.demo.dto.UserResponse;
import br.edu.ifpb.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserResponse> buscarTodos() {
        return service.buscarTodosUsuarios();
    }

    @PostMapping
    public UserResponse cadastrar(
            @Valid @RequestBody UserRequest request) {
        return service.cria(request);
    }

    @PutMapping
    public UserResponse atualizar(
            @Valid @RequestBody UserRequest request) {
        return service.atualizarUsuario(request);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletarUsuario(id);
    }
}
