package br.edu.ifpb.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import jakarta.persistence.*;
        import java.time.LocalDateTime;

@Entity
@Table(name = "tb_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String texto;

    private LocalDateTime criadoEm;

    @ManyToOne(optional = false)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User autor;

    public Comment() {
    }

    public Comment(String texto, Post post, User autor) {
        this.texto = texto;
        this.post = post;
        this.autor = autor;
        this.criadoEm = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public Post getPost() {
        return post;
    }

    public User getAutor() {
        return autor;
    }
}
