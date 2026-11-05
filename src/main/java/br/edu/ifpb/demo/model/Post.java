package br.edu.ifpb.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import jakarta.persistence.*;
        import java.time.LocalDateTime;

@Entity
@Table(name = "tb_post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String imagemUrl;

    @Column(length = 300)
    private String legenda;

    private LocalDateTime criadoEm;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User autor;

    public Post() {
    }

    public Post(String imagemUrl, String legenda, User autor) {
        this.imagemUrl = imagemUrl;
        this.legenda = legenda;
        this.autor = autor;
        this.criadoEm = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public String getLegenda() {
        return legenda;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public User getAutor() {
        return autor;
    }
}
