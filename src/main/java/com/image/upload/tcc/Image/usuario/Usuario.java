package com.image.upload.tcc.Image.usuario;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    @NotBlank
    private String email;
    @Column(nullable = false)
    @NotBlank
    private String senha;

    @Column
    private Long imageid;

    public Usuario() {

    }

    public Usuario(String nome, String email, String senha, Long id) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.imageid = id;
    }
}
