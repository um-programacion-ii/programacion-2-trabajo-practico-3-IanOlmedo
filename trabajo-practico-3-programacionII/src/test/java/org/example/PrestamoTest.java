package org.example;
import org.junit.jupiter.api.*;
import org.example.modelo.*;
import org.example.estados.*;
import org.example.gestores.*;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PrestamoTest {
    
    @Mock
    private Catalogo catalogo;

    @InjectMocks
    private GestorPrestamos gestorPrestamos;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPrestarLibro() {
        Libro libro1 = new Libro("123-123", "StarWars", "John");
        Libro libro2 = new Libro("111-111", "DBZ", "Ian");

        when(catalogo.buscarPorIsbn("123-123")).thenReturn(libro1);

        Prestamo prestamo = gestorPrestamos.prestarLibro("123-123");

        assertNotNull(prestamo);
        verify(catalogo).buscarPorIsbn("123-123");
        assertEquals(EstadoLibro.PRESTADO, libro1.getEstado());
        assertEquals(EstadoLibro.DISPONIBLE, libro2.getEstado());
    }

}
