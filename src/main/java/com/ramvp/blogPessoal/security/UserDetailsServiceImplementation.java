package com.ramvp.blogPessoal.security;

import com.ramvp.blogPessoal.model.Usuario;
import com.ramvp.blogPessoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<Usuario> user = repository.findByUsuario(username);
        user.orElseThrow(() -> new UsernameNotFoundException(username + " not found."));

        return user.map(UserDetailsImplement::new).get();
    }

}
