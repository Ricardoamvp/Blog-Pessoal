package com.ramvp.blogPessoal.model;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UsuarioTest {

    public Usuario usuario;

    @BeforeEach
    public void iniciar() {
        usuario = new Usuario("Ricardo", "senha");
    }

    @Test
    void testValidacaoAtributos() {
        assertAll(() -> assertTrue(usuario.getUsuario() != null),
                () -> assertTrue(usuario.getSenha() != null));
    }

}
