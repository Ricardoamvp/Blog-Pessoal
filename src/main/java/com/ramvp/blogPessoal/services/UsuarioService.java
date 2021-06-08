package com.ramvp.blogPessoal.services;

import com.ramvp.blogPessoal.model.Usuario;
import com.ramvp.blogPessoal.model.UsuarioLogin;
import com.ramvp.blogPessoal.repository.UsuarioRepository;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public Usuario CadastrarUsuario(Usuario usuario) {
        //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String senhaEncoder = encoder.encode(usuario.getSenha());
        usuario.setSenha(senhaEncoder);

        return repository.save(usuario);
    }

    public Optional<UsuarioLogin> LogarUsuario(Optional<UsuarioLogin> usuario) {
        //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Optional<Usuario> user = repository.findByUsuario(usuario.get().getUsuario());

        if(user.isPresent()) {
            if(encoder.matches(usuario.get().getSenha(), user.get().getSenha())) {
                String auth = usuario.get().getUsuario() + ":" + usuario.get().getSenha();
                //Testar
                byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.US_ASCII));
                String authHeader = "Basic" + new String(encodedAuth);

                usuario.get().setToken(authHeader);
                usuario.get().setNome(user.get().getNome());

                return usuario;
            }
        }
            return null;
    }

}
