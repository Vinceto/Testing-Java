package Vinceto.D33;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
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
        when(dbMock.containsKey("123")).thenReturn(false);
        when(dbMock.put(eq("123"), eq(libro))).thenReturn(null);

        String resultado = repo.guardarLibro(libro);
        assertEquals("Libro guardado exitosamente.", resultado);

        verify(dbMock, times(1)).containsKey("123");
        verify(dbMock, times(1)).put("123", libro);

        // Caso 2: Intentar guardar un libro con el mismo ISBN
        when(dbMock.containsKey("123")).thenReturn(true);

        resultado = repo.guardarLibro(libro);
        assertEquals("Libro ya existe con ese ISBN.", resultado);

        verify(dbMock, times(2)).containsKey("123"); // Verifica dos veces debido al caso anterior y este

        // Caso 3: Guardar otro libro con un ISBN diferente
        Libro libro2 = new Libro("456", "Advanced Java");
        when(dbMock.containsKey("456")).thenReturn(false);
        when(dbMock.put(eq("456"), eq(libro2))).thenReturn(null);

        resultado = repo.guardarLibro(libro2);
        assertEquals("Libro guardado exitosamente.", resultado);

        verify(dbMock, times(1)).containsKey("456");
        verify(dbMock, times(1)).put("456", libro2);
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

        verify(dbMock, times(1)).containsKey("123");
        verify(dbMock, times(1)).put("123", libro);

        // Caso 2: Actualizar un libro no existente
        Libro libroNuevo = new Libro("456", "Advanced Java");
        when(dbMock.containsKey("456")).thenReturn(false);

        resultado = repo.actualizarLibro(libroNuevo);
        assertEquals("Libro no encontrado con ese ISBN.", resultado);

        verify(dbMock, times(1)).containsKey("456");
        verify(dbMock, never()).put(eq("456"), any());

        // Caso 3: Intentar actualizar un libro con ISBN nulo
        Libro libroNulo = new Libro(null, "Null Book");
        resultado = repo.actualizarLibro(libroNulo);
        assertEquals("ISBN del libro es nulo.", resultado);

        verify(dbMock, never()).containsKey(null);
        verify(dbMock, never()).put(eq(null), any());
    }

    @Test
    public void testEliminarLibro() {
        when(dbMock.containsKey("123")).thenReturn(true);
        when(dbMock.remove("123")).thenReturn(null);

        // Caso 1: Eliminar un libro existente
        String resultado = repo.eliminarLibro("123");
        assertEquals("Libro eliminado exitosamente.", resultado);

        verify(dbMock, times(1)).containsKey("123");
        verify(dbMock, times(1)).remove("123");

        // Caso 2: Eliminar un libro no existente
        when(dbMock.containsKey("456")).thenReturn(false);

        resultado = repo.eliminarLibro("456");
        assertEquals("Libro no encontrado con ese ISBN.", resultado);

        verify(dbMock, times(1)).containsKey("456");
        verify(dbMock, never()).remove(eq("456"));

        // Caso 3: Intentar eliminar un libro con ISBN nulo
        String resultadoNulo = repo.eliminarLibro(null);
        assertEquals("ISBN del libro es nulo.", resultadoNulo);

        verify(dbMock, never()).containsKey(null);
        verify(dbMock, never()).remove(null);
    }

    @Test
    public void testObtenerLibroPorIsbn() {
        Libro libro = new Libro("123", "Java Basics");
        when(dbMock.get("123")).thenReturn(libro);

        // Caso 1: Obtener un libro existente
        Optional<Libro> libroObtenido = repo.obtenerLibroPorIsbn("123");
        assertTrue(libroObtenido.isPresent());
        assertEquals("Java Basics", libroObtenido.get().getTitulo());

        verify(dbMock, times(1)).get("123");

        // Caso 2: Obtener un libro no existente
        when(dbMock.get("456")).thenReturn(null);

        libroObtenido = repo.obtenerLibroPorIsbn("456");
        assertFalse(libroObtenido.isPresent());

        verify(dbMock, times(1)).get("456");

        // Caso 3: Intentar obtener un libro con ISBN nulo
        libroObtenido = repo.obtenerLibroPorIsbn(null);
        assertFalse(libroObtenido.isPresent());

        verify(dbMock, never()).get(null);
    }
}