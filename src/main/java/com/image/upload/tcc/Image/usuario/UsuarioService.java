package com.image.upload.tcc.Image.usuario;

import com.image.upload.tcc.Image.base64.Image;
import com.image.upload.tcc.Image.base64.ImageService;
import com.image.upload.tcc.Image.usuario.records.UserRegister;
import com.image.upload.tcc.Image.usuario.records.UserWithImageBase64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;

@Service
public class UsuarioService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ImageService imageService;

    public Usuario register(UserRegister user) throws IOException {
        Image image = this.imageService.saveImage(user.image());

        Usuario usuario = new Usuario(user.nome(), user.email(), user.senha(), image.getId());
        this.repository.save(usuario);

        return usuario;
    }

    public UserWithImageBase64 findById(Long id) throws IOException {
        Usuario user = this.repository.findById(id).get();
        String image = this.imageService.getImage(user.getImageid());

        return new UserWithImageBase64(user.getId(), user.getNome(), user.getEmail(), user.getSenha(), image);
    }



}
