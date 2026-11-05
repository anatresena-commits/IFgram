package br.edu.ifpb.demo.repository;

import br.edu.ifpb.demo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPostIdOrderByCriadoEmAsc(Long postId);

    long countByPostId(Long postId);

    List<Comment> findByAutorId(Long autorId);
}
