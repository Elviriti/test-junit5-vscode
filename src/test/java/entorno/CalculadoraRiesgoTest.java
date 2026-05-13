package entorno;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculadoraRiesgoTest {
    CalculadoraRiesgo calc = new CalculadoraRiesgo();

    @Test
    void testEdadNegativa() {
        assertEquals("Error", calc.evaluarEdad(-5));
    }

    @Test
    void testAdulto() {
        assertEquals("Adulto", calc.evaluarEdad(25));
    }
    
    @Test
    void testSenior() {
        assertEquals("Senior", calc.evaluarEdad(70));
    }

    @Test
    void testLimite18() {
        assertEquals("Adulto", calc.evaluarEdad(18));
    }
}
