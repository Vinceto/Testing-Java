package Vinceto.D33;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RepositorioLibro {
    private Map<String, Libro> db = new HashMap<>();

    // Método para guardar un libro
    public String guardarLibro(Libro libro) {
        if (db.containsKey(libro.getIsbn())) {
            return "Libro ya existe con ese ISBN.";
        }
        db.put(libro.getIsbn(), libro);
        return "Libro guardado exitosamente.";
    }

    // Método para obtener un libro por ISBN
    public Optional<Libro> obtenerLibroPorIsbn(String isbn) {
        return Optional.ofNullable(db.get(isbn));
    }

    // Método para actualizar un libro
    public String actualizarLibro(Libro libro) {
        if (libro.getIsbn() == null) {
            return "ISBN del libro es nulo.";
        }
        if (!db.containsKey(libro.getIsbn())) {
            return "Libro no encontrado con ese ISBN.";
        }
        db.put(libro.getIsbn(), libro);
        return "Libro actualizado exitosamente.";
    }

    // Método para eliminar un libro
    public String eliminarLibro(String isbn) {
        if (isbn == null) {
            return "ISBN del libro es nulo.";
        }
        if (!db.containsKey(isbn)) {
            return "Libro no encontrado con ese ISBN.";
        }
        db.remove(isbn);
        return "Libro eliminado exitosamente.";
    }

    // Setter para db
    public void setDb(Map<String, Libro> db) {
        this.db = db;
    }
}