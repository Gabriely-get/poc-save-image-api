package com.image.upload.tcc.Image.usuario.records;

import com.image.upload.tcc.Image.usuario.Usuario;

public record UserDetails(Long id, String nome, String email, String senha, Long imageId) {
    public UserDetails(Usuario newUser) {
        this (
            newUser.getId(),
            newUser.getNome(),
            newUser.getEmail(),
            newUser.getSenha(),
            newUser.getImageid()
        );
    }
}
