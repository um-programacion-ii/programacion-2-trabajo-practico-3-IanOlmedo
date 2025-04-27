package org.example.modelo;

import lombok.Getter;
import java.time.LocalDate;

@Getter
public class Prestamo {
    private final Libro libro;
    private final LocalDate fechaPrestamo;

    public Prestamo(Libro libro) {
        this.libro = libro;
        this.fechaPrestamo = LocalDate.now();
    }
}

