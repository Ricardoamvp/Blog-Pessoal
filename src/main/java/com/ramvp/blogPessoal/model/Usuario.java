package com.ramvp.blogPessoal.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Construtor para testes
    public Usuario() {

    }

    public Usuario(@NotNull String usuario, @NotNull String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    @NotBlank
    @Size(min = 3, max = 30)
    private String nome;

    @NotBlank
    @Size(min = 3, max = 30)
    private String usuario;

    @NotBlank
    @Size(min = 5, max = 100)
    private String senha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
