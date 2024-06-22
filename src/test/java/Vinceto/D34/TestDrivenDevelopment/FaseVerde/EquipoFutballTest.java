package Vinceto.D34.TestDrivenDevelopment.FaseVerde;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EquipoFutballTest {
    @Test
    public void constructorDebeSetearJuegosGanados() {
        EquipoFutball team = new EquipoFutball(3);
        assertEquals(3, team.getJuegosGanados());
    }
}
