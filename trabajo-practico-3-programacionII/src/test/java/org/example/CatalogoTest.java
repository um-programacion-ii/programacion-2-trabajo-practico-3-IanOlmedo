package org.example;

import org.example.modelo.*;
import org.example.estados.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class CatalogoTest {
    private Catalogo catalogo;
    private Libro libro1;
    private Libro libro2;

    @BeforeEach
    void setUp() {
        catalogo = new Catalogo();
        libro1 = new Libro("978-3-16-148410-0", "Luke Skywalker", "Robert C. Martin");
        libro2 = new Libro("978-0-13-235088-4", "Clean Architecture", "Robert C. Martin");
        catalogo.agregarLibro(libro1);
        catalogo.agregarLibro(libro2);
    }

    @Test
    void testBuscarPorIsbn(){
        Libro libro = catalogo.buscarPorIsbn("978-3-16-148410-0");
        assertNotNull(libro);
        assertEquals("Luke Skywalker", libro.getTitulo());
    }

    @Test
    void testObtenerLibrosDisponibles(){
        libro2.setEstado(EstadoLibro.PRESTADO);
        var disponibles = catalogo.obtenerLibrosDisponibles();
        assertEquals(1, disponibles.size());
        assertEquals("Luke Skywalker", disponibles.get(0).getTitulo());
    }

    @Test
    void testBuscarPorIsbninexistente(){
        assertEquals(null, catalogo.buscarPorIsbn("00-00-00-00"));
    }


}
