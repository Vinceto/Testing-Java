package Vinceto.D33;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RepositorioPersonaTest {
    private RepositorioPersona repositorioPersona = mock(RepositorioPersona.class);

    @Test
    public void testCrearPersona() {
        Persona pepe = new Persona("1-2", "Pepe");
        //when(repositorioPersona.crearPersona(pepe)).thenReturn("OK");
        when(repositorioPersona.crearPersona(null)).thenThrow(new NullPointerException());
        String crearPersonaRes = repositorioPersona.crearPersona(pepe);
        assertEquals("OK", crearPersonaRes);
        verify(repositorioPersona).crearPersona(pepe);
    }

    @Test
    public void testActualizarPersona () {
        Persona juanito = new Persona("1-2", "Juanito");
        when(repositorioPersona.actualizarPersona(juanito)).thenReturn(
                "OK"); String actualizarRes =
                repositorioPersona.actualizarPersona(juanito);
        assertEquals("OK", actualizarRes);
        verify(repositorioPersona).actualizarPersona(juanito);
    }

    @Test
    public void testEliminarPersona() {
        Persona juanito = new Persona("1-2", "Juanito");

        // Simula el comportamiento del método eliminarPersona
        when(repositorioPersona.eliminarPersona(juanito)).thenReturn("OK");

        // Ejecuta el método eliminarPersona y verifica el resultado
        String eliminarRes = repositorioPersona.eliminarPersona(juanito);
        assertEquals("OK", eliminarRes);

        // Verifica que el método eliminarPersona fue llamado con el objeto juanito
        verify(repositorioPersona).eliminarPersona(juanito);
    }

    @Test
    public void testListarPersonas() {
        Map<String, String> dbSimulado = new HashMap<>();
        dbSimulado.put("1-2", "Pepe");
        dbSimulado.put("2-3", "Juanito");

        // Simula el comportamiento del método listarPersonas
        when(repositorioPersona.listarPersonas()).thenReturn(dbSimulado);

        // Ejecuta el método listarPersonas y verifica el resultado
        Map<String, String> listarRes = repositorioPersona.listarPersonas();
        assertEquals(dbSimulado, listarRes);

        // Verifica que el método listarPersonas fue llamado
        verify(repositorioPersona).listarPersonas();
    }
}
