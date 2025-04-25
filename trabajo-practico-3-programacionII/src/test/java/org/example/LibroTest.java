package org.example;

import org.example.modelo.Libro;
import org.example.estados.EstadoLibro;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibroTest{

    @Test
    void testCrearLibroValido(){
        Libro libro = new Libro("978-3-16-148410-0", "Prueba", "Luke Skywalker");

        assertEquals("978-3-16-148410-0", libro.getIsbn());
        assertEquals("Prueba", libro.getTitulo());
        assertEquals("Luke Skywalker", libro.getAutor());
        assertEquals(EstadoLibro.DISPONIBLE, libro.getEstado());
    }

    @Test
    void testCambiarEstadoLibro(){
        Libro libro = new Libro("978-3-16-148410-0", "Prueba", "Luke Skywalker");

        libro.setEstado(EstadoLibro.PRESTADO);
        assertEquals(EstadoLibro.PRESTADO, libro.getEstado());
    }
}