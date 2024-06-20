package Vinceto.D32;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculadoraTest {

    @Test
    public void testSumar() {
        Calculadora calc = new Calculadora();
        int resultado = calc.sumar(2, 3);
        assertEquals("Error en la suma: 2 + 3 debe ser 5", 5, resultado);
        System.out.println("Test Sumar: 2 + 3 = " + resultado);
    }

    @Test
    public void testRestar() {
        Calculadora calc = new Calculadora();
        int resultado = calc.restar(3, 2);
        assertEquals("Error en la resta: 3 - 2 debe ser 1", 1, resultado);
        System.out.println("Test Restar: 3 - 2 = " + resultado);
    }

    @Test
    public void testMultiplicar() {
        Calculadora calc = new Calculadora();
        int resultado = calc.multiplicar(2, 3);
        assertEquals("Error en la multiplicación: 2 * 3 debe ser 6", 6, resultado);
        System.out.println("Test Multiplicar: 2 * 3 = " + resultado);
    }

    @Test
    public void testDividir() {
        Calculadora calc = new Calculadora();
        int resultado = calc.dividir(6, 3);
        assertEquals("Error en la división: 6 / 3 debe ser 2", 2, resultado);
        System.out.println("Test Dividir: 6 / 3 = " + resultado);
    }

    @Test(expected = ArithmeticException.class)
    public void testDividirPorCero() {
        Calculadora calc = new Calculadora();
        calc.dividir(1, 0);
        System.out.println("Test Dividir por Cero: 1 / 0");
    }
}