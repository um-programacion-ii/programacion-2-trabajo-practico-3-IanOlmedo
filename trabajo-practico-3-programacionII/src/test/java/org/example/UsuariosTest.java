package org.example;

import org.example.gestores.*;
import org.example.modelo.*;
import org.example.estados.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class GestionUsuariosTest {

    @Mock
    private Catalogo catalogo;

    @Mock
    private GestorPrestamos gestorPrestamos;

    @InjectMocks
    private GestorUsuarios gestionUsuarios;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        gestionUsuarios.registrarUsuario("45716948", "Ian", "Olmedo");
    }

    @Test
    void testRegistrarPrestamo() {
        Libro libro = new Libro("123-123", "Clean Code", "Robert C. Martin");
        Prestamo prestamo = new Prestamo(libro);

        when(gestorPrestamos.prestarLibro("123-123")).thenReturn(prestamo);

        gestionUsuarios.registrarPrestamo("45716948", "123-123");

        verify(gestorPrestamos).prestarLibro("123-123");
        assertEquals(1, gestionUsuarios.getUsuarios().get("usuario1").getHistorialPrestamos().size());
    }

    @Test
    void testRegistrarUsuarioExistente() {
        assertThrows(IllegalArgumentException.class, () -> {
            gestionUsuarios.registrarUsuario("26442785", "Roberto", "Olmedo");
        });
    }

    @Test
    void testRegistrarPrestamoUsuarioInexistente() {
        assertThrows(IllegalArgumentException.class, () -> {
            gestionUsuarios.registrarPrestamo("Rafa Polinesio", "123-123");
        });
    }
}
