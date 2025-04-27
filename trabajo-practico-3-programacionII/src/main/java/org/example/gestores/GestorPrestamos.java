package org.example.gestores;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.estados.EstadoLibro;
import org.example.modelo.*;

@Getter

public class GestorPrestamos {
    private final Catalogo catalogo;

    public GestorPrestamos(Catalogo catalogo){
        this.catalogo = catalogo;
    }

    public Prestamo prestarLibro(String isbn){
        Libro libro = catalogo.buscarPorIsbn(isbn);
        if (libro != null && libro.getEstado() == EstadoLibro.DISPONIBLE){
            libro.setEstado(EstadoLibro.PRESTADO);
            return new Prestamo(libro);
        }
        return null;

    }
}
