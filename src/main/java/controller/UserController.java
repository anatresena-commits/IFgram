package controller;

import dto.UserRequest;
import dto.UserResponse;
import org.springframework.web.bind.annotation.*;
import service.UserService;

@RestController
@RequestMapping("user")

public class UserController {
 public final UserService service;

    public UserController(UserService service){
        this.service = service;
    }
    @GetMapping
    public String getUser() {
        return "chamei o endpoint como um GET!";

    }

    @PostMapping
    public String postUser(){
        return "chamei o endpoint como um POST!";
    }

    @PutMapping
public UserResponse putUser (UserRequest request) throws Exception {
        UserResponse userResponse = service.atualizarUsuario(request);
        return userResponse;
    }
    @DeleteMapping
    public String deleteUser(){
        return "chamei o endpoint como um DELETE!";
    }
}

