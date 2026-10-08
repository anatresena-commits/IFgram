package service;

import dto.UserRequest;
import dto.UserResponse;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import repository.UserRepository;

@Service
public class UserService {
    private final UserRepository repository;

    // injeção de dependêcia pelo construtor
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public UserResponse cria(UserRequest request) throws Exception {
        // regra de negócios: o e-mail não pode repetir
        if (repository.existsByEmail(request.email())) {
            throw new Exception(request.email());
        }
        User salvo;
        salvo = repository.save(new User(request.nome(), request.email()));
        return UserResponse.from(salvo);
    }
}


