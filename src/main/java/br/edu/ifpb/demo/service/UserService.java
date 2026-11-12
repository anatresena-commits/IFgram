
package br.edu.ifpb.demo.service;

import br.edu.ifpb.demo.dto.UserRequest;
import br.edu.ifpb.demo.dto.UserResponse;
import br.edu.ifpb.demo.model.User;
import br.edu.ifpb.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public UserResponse cria(UserRequest request) {

        if (repository.existsByEmail(request.email())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Este e-mail já está cadastrado."
            );
        }

        User usuario = new User(
                request.nome(),
                request.email(),
                request.senha()
        );

        User salvo = repository.save(usuario);

        return UserResponse.from(salvo);
    }

    public List<UserResponse> buscarTodosUsuarios() {
        return repository.findAll()
                .stream()
                .map(UserResponse::from)
                .toList();
    }

    @Transactional
    public UserResponse atualizarUsuario(UserRequest request) {

        User usuario = repository.findByEmail(request.email())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Usuário não encontrado."
                ));

        usuario.setNome(request.nome());
        usuario.setSenha(request.senha());

        User atualizado = repository.save(usuario);

        return UserResponse.from(atualizado);
    }

    @Transactional
    public void deletarUsuario(Long id) {

        if (!repository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Usuário não encontrado."
            );
        }

        repository.deleteById(id);
    }
}
