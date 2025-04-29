package org.example.modelo;

import java.util.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Usuario {
    private String dni;
    private String nombre;
    private String apellido;
    private List<Prestamo> historialPrestamos = new ArrayList<>();

    public Usuario(String dni, String nombre, String apellido){
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void agregarPrestamo(Prestamo prestamo){
        historialPrestamos.add(prestamo);
    }

    public List<Prestamo> getHistorialPrestamos() {
        return historialPrestamos;
    }
}
