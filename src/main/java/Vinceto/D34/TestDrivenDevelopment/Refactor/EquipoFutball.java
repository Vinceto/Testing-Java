package Vinceto.D34.TestDrivenDevelopment.Refactor;

public class EquipoFutball {
    private int juegosGanados;
    private int juegosPerdidos;
    private int juegosEmpatados;

    // Constructor con todos los atributos
    public EquipoFutball(int juegosGanados, int juegosPerdidos, int juegosEmpatados) {
        this.juegosGanados = juegosGanados;
        this.juegosPerdidos = juegosPerdidos;
        this.juegosEmpatados = juegosEmpatados;
    }

    // Getter para juegosGanados
    public int getJuegosGanados() {
        return juegosGanados;
    }

    // Setter para juegosGanados
    public void setJuegosGanados(int juegosGanados) {
        this.juegosGanados = juegosGanados;
    }

    // Getter para juegosPerdidos
    public int getJuegosPerdidos() {
        return juegosPerdidos;
    }

    // Setter para juegosPerdidos
    public void setJuegosPerdidos(int juegosPerdidos) {
        this.juegosPerdidos = juegosPerdidos;
    }

    // Getter para juegosEmpatados
    public int getJuegosEmpatados() {
        return juegosEmpatados;
    }

    // Setter para juegosEmpatados
    public void setJuegosEmpatados(int juegosEmpatados) {
        this.juegosEmpatados = juegosEmpatados;
    }

    // Método toString
    @Override
    public String toString() {
        return "EquipoFutball{" +
                "juegosGanados=" + juegosGanados +
                ", juegosPerdidos=" + juegosPerdidos +
                ", juegosEmpatados=" + juegosEmpatados +
                '}';
    }
}