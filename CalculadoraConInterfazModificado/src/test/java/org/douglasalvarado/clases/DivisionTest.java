package org.douglasalvarado.clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisionTest {

    Division division = new Division();
    Double expectedResulOne = 5.00;
    Double digitOne = 25.00;
    Double digitTwo = 5.00;
    Double digitThree = 0.00;
    String expected = "División";

    @Test
    void operation() {
        Double result = division.operation(digitOne, digitTwo);
        assertEquals(expectedResulOne, result, "Resultado de la Division es incorrecta");
    }

    @Test
    void operationError() {
        Division division = new Division();
        Double result = division.operation(digitOne, digitThree);
        assertEquals(digitThree, result, "Resultado de la Division es incorrecta");
    }

    @Test
    void description(){
        String text = division.description();
        assertEquals(expected, text);
    }
}