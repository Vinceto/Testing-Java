package Vinceto.D33;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RepositorioLibroTest {

    private RepositorioLibro repo;
    private Map<String, Libro> dbMock;

    @Before
    public void setUp() {
        dbMock = mock(HashMap.class);
        repo = new RepositorioLibro();
        repo.setDb(dbMock);
    }

    @Test
    public void testGuardarLibro() {
        Libro libro = new Libro("123", "Java Basics");

        // Caso 1: Guardar un libro nuevo

        // Configura el comportamiento simulado para el método containsKey del dbMock. Retorna false cuando se llama con la clave "123".
        // "Cuando la key 123 no exista"
        when(dbMock.containsKey("123")).thenReturn(false);

        // Configura el comportamiento simulado para el método put del dbMock. Retorna null cuando se llama con la clave "123" y el libro libro.
        when(dbMock.put(eq("123"), eq(libro))).thenReturn(null);

        // Llama al método guardarLibro del repositorio y guarda el resultado.
        String resultado = repo.guardarLibro(libro);

        // Verifica que el resultado obtenido sea el esperado.
        assertEquals("Libro guardado exitosamente.", resultado);

        // Caso 2: Guardar un libro con el mismo ISBN
        when(dbMock.containsKey("123")).thenReturn(true);
        resultado = repo.guardarLibro(libro);
        assertEquals("Libro ya existe con ese ISBN.", resultado);

        // Caso 3: Guardar otro libro con un ISBN diferente
        Libro libro2 = new Libro("456", "Advanced Java");
        when(dbMock.containsKey("456")).thenReturn(false);
        when(dbMock.put(eq("456"), eq(libro2))).thenReturn(null);

        resultado = repo.guardarLibro(libro2);
        assertEquals("Libro guardado exitosamente.", resultado);
    }

    @Test
    public void testObtenerLibroPorIsbn() {
        Libro libro = new Libro("123", "Java Basics");
        when(dbMock.get("123")).thenReturn(libro);

        // Caso 1: Obtener un libro existente
        Optional<Libro> libroObtenido = repo.obtenerLibroPorIsbn("123");
        assertTrue(libroObtenido.isPresent());
        assertEquals("Java Basics", libroObtenido.get().getTitulo());

        // Caso 2: Obtener un libro no existente
        when(dbMock.get("456")).thenReturn(null);
        libroObtenido = repo.obtenerLibroPorIsbn("456");
        assertFalse(libroObtenido.isPresent());

        // Caso 3: Intentar obtener un libro con ISBN nulo
        libroObtenido = repo.obtenerLibroPorIsbn(null);
        assertFalse(libroObtenido.isPresent());
    }

    @Test
    public void testActualizarLibro() {
        Libro libro = new Libro("123", "Java Basics");
        when(dbMock.containsKey("123")).thenReturn(true);
        when(dbMock.put(eq("123"), eq(libro))).thenReturn(null);

        // Caso 1: Actualizar un libro existente
        libro.setTitulo("Java Basics Updated");
        String resultado = repo.actualizarLibro(libro);
        assertEquals("Libro actualizado exitosamente.", resultado);

        // Caso 2: Actualizar un libro no existente
        Libro libroNuevo = new Libro("456", "Advanced Java");
        when(dbMock.containsKey("456")).thenReturn(false);
        when(dbMock.put(eq("456"), eq(libroNuevo))).thenReturn(null);

        resultado = repo.actualizarLibro(libroNuevo);
        assertEquals("Libro no encontrado con ese ISBN.", resultado);

        // Caso 3: Intentar actualizar un libro con ISBN nulo
        Libro libroNulo = new Libro(null, "Null Book");
        resultado = repo.actualizarLibro(libroNulo);
        assertEquals("ISBN del libro es nulo.", resultado);
    }

    @Test
    public void testEliminarLibro() {
        when(dbMock.containsKey("123")).thenReturn(true);
        when(dbMock.remove("123")).thenReturn(null);

        // Caso 1: Eliminar un libro existente
        String resultado = repo.eliminarLibro("123");
        assertEquals("Libro eliminado exitosamente.", resultado);

        // Caso 2: Eliminar un libro no existente
        when(dbMock.containsKey("456")).thenReturn(false);
        resultado = repo.eliminarLibro("456");
        assertEquals("Libro no encontrado con ese ISBN.", resultado);

        // Caso 3: Intentar eliminar un libro con ISBN nulo
        String resultadoNulo = repo.eliminarLibro(null);
        assertEquals("ISBN del libro es nulo.", resultadoNulo);
    }
}