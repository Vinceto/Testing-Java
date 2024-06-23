package Vinceto.D34.TestDrivenDevelopment.Refactor;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EquipoFutballTest {
    private static final int JUEGOS_GANADOS = 4;
    private static final int JUEGOS_PERDIDOS = 2;
    private static final int JUEGOS_EMPATADOS = 3;
    private static final int CINCO_JUEGOS_EMPATADOS = 5;
    private static final int TRES_JUEGOS_PERDIDOS = 3;

    @Test
    public void constructorDebeSetearJuegosCorrectamente() {
        EquipoFutball team = new EquipoFutball(JUEGOS_GANADOS, JUEGOS_PERDIDOS, JUEGOS_EMPATADOS);
        assertEquals(JUEGOS_GANADOS, team.getJuegosGanados());
        assertEquals(JUEGOS_PERDIDOS, team.getJuegosPerdidos());
        assertEquals(JUEGOS_EMPATADOS, team.getJuegosEmpatados());
    }

    @Test
    public void verificarJuegosPerdidos() {
        EquipoFutball team = new EquipoFutball(JUEGOS_GANADOS, TRES_JUEGOS_PERDIDOS, JUEGOS_EMPATADOS);
        assertEquals(TRES_JUEGOS_PERDIDOS, team.getJuegosPerdidos());
    }

    @Test
    public void verificarJuegosEmpatados() {
        EquipoFutball team = new EquipoFutball(JUEGOS_GANADOS, JUEGOS_PERDIDOS, CINCO_JUEGOS_EMPATADOS);
        assertEquals(CINCO_JUEGOS_EMPATADOS, team.getJuegosEmpatados());
    }
}
