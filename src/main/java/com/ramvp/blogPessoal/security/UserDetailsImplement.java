package com.ramvp.blogPessoal.security;

import com.ramvp.blogPessoal.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserDetailsImplement implements UserDetails {

    private static final long serialVersionUIDLONG = 1L;

    private String username;
    private String password;

    public UserDetailsImplement(Usuario user) {
        this.username = user.getUsuario();
        this.password = user.getSenha();
    }

    public UserDetailsImplement() {}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
