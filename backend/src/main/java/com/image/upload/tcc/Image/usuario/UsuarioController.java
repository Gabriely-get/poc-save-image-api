package com.image.upload.tcc.Image.usuario;

import com.image.upload.tcc.Image.usuario.records.UserDetails;
import com.image.upload.tcc.Image.usuario.records.UserRegister;
import com.image.upload.tcc.Image.usuario.records.UserWithImageBase64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UsuarioController {
    @Autowired
    private UserRepository repository;

    @Autowired
    private UsuarioService service;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegister user, UriComponentsBuilder uriBuilder) throws IOException {
//        System.out.println(user.image());
        Usuario newUser = this.service.register(user);

        var uri = uriBuilder.path("/user/{id}").buildAndExpand(newUser.getId()).toUri();

        return ResponseEntity.created(uri).body(new UserDetails(newUser));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) throws IOException {
        UserWithImageBase64 usuario = this.service.findById(id);

        return ResponseEntity.ok(usuario);
    }

}
