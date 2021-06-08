package com.ramvp.blogPessoal.controller;

import com.ramvp.blogPessoal.model.Usuario;
import com.ramvp.blogPessoal.model.UsuarioLogin;
import com.ramvp.blogPessoal.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/login")
    public ResponseEntity<UsuarioLogin> Logar (@RequestBody Optional<UsuarioLogin> usuario) {
        return service.LogarUsuario(usuario).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Usuario> Cadastrar (@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.CadastrarUsuario(usuario));
    }
}
