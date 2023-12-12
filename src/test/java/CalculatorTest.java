import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void sommeTest_nouvelle_fonctionnalite() {
        var x = 0;
        var y = 0;

        var resultat = Calculator.somme(x, y);

        assertEquals(1, resultat);
    }

    // cas de test
    @Test
    void sommeTest() {
        var x = 1;
        var y = 2;

        var resultat = Calculator.somme(x, y);

        assertEquals(3, resultat);
    }

    @Test
    void sommeTest2() {
        var x = 10;
        var y = 22;

        var resultat = Calculator.somme(x, y);

        assertEquals(32, resultat);
    }

    @Test
    void sommeTest3() {
        var x = -10;
        var y = 22;

        var resultat = Calculator.somme(x, y);

        assertEquals(12, resultat);
    }

    @Test
    void divisionTest1() {
        var x = 10;
        var y = 2;

        var resultat = Calculator.division(x, y);

        assertEquals(5, resultat);
    }

    @Test
    void divisionTest2() {
        var x = 1;
        var y = 1;

        var resultat = Calculator.division(x, y);

        assertEquals(1, resultat);
    }

    @Test
    void divisionTest3() {
        var x = 0;
        var y = 1;

        var resultat = Calculator.division(x, y);

        assertEquals(0, resultat);
    }

    @Test
    void divisionTest4() {
        var x = 1;
        var y = 0;

        assertThrows(ArithmeticException.class, () -> Calculator.division(x, y));
    }

}