package com.luan.ecommerce.ecommerce.recurso;

import com.luan.ecommerce.ecommerce.builder.UsuarioBuilder;
import com.luan.ecommerce.ecommerce.repositorio.UsuarioRepositorio;
import com.luan.ecommerce.ecommerce.servico.mapper.UsuarioMapper;
import com.luan.ecommerce.ecommerce.utills.IntTestComum;
import org.apache.http.util.Asserts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Transactional
@ExtendWith(SpringExtension.class)
public class UsuarioRecursoIT extends IntTestComum {

    @Autowired
    private UsuarioBuilder usuarioBuilder;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private UsuarioMapper usuarioMapper;

    @BeforeEach
    public void inicializar() {
        usuarioRepositorio.deleteAll();
    }

    @Test
    public void listarTest() throws Exception {
        usuarioBuilder.construir();

        getMockMvc().perform(get("/api/usuarios"))

                .andExpect(status().isOk());
    }
}
