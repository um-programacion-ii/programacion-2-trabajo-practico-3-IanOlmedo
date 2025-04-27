package org.example.gestores;
import java.util.*;

import lombok.Getter;
import lombok.Setter;
import org.example.modelo.*;

@Getter
@Setter

public class GestorUsuarios {
    private Catalogo catalogo;
    private GestorPrestamos gestorPrestamos;
    private Map<String, Usuario> usuarios = new HashMap<>();

    public GestorUsuarios(Catalogo catalogo, GestorPrestamos gestorPrestamos){
        this.catalogo = catalogo;
        this.gestorPrestamos = gestorPrestamos;
    }

    public void registrarUsuario (String dni, String nombre, String apellido){
        if (usuarios.containsKey(dni)) {
            throw new IllegalArgumentException("El usuario ya existe.");
        }
        usuarios.put(dni, new Usuario(dni, nombre, apellido));
    }

    public void registrarPrestamo(String dni, String isbn) {
        Usuario usuario = usuarios.get(dni);
        if (usuario == null) {
            throw new IllegalArgumentException("No existe el usuario");
        }
        Prestamo prestamo = gestorPrestamos.prestarLibro(isbn);
        if (prestamo == null) {
            throw new IllegalStateException("No se puede realizar el prestamo");
        }

        usuario.agregarPrestamo(prestamo);
    }

    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }
}
