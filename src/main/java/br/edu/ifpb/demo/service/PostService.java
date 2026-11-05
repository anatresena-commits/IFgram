package br.edu.ifpb.demo.service;

import br.edu.ifpb.demo.dto.PostRequest;
import br.edu.ifpb.demo.dto.PostResponse;
import br.edu.ifpb.demo.model.Post;
import br.edu.ifpb.demo.model.User;
import br.edu.ifpb.demo.repository.PostRepository;
import br.edu.ifpb.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository,
                       UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public PostResponse criar(PostRequest request) {

        User autor = userRepository.findById(request.autorId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Usuário não encontrado."
                ));

        Post post = new Post(
                request.imagemUrl(),
                request.legenda(),
                autor
        );

        Post salvo = postRepository.save(post);

        return PostResponse.from(salvo);
    }

    public List<PostResponse> listarFeed() {
        return postRepository.listarFeed()
                .stream()
                .map(PostResponse::from)
                .toList();
    }

    public List<PostResponse> listarPorAutor(Long autorId) {
        return postRepository.findByAutorId(autorId)
                .stream()
                .map(PostResponse::from)
                .toList();
    }

    public PostResponse buscarPorId(Long id) {

        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Post não encontrado."
                ));

        return PostResponse.from(post);
    }

    @Transactional
    public void deletar(Long id) {

        if (!postRepository.existsById(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Post não encontrado."
            );
        }

        postRepository.deleteById(id);
    }
}

