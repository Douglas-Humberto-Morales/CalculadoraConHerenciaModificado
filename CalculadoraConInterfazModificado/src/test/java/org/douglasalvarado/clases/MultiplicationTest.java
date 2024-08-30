package org.douglasalvarado.clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicationTest {

    Multiplication multiplication = new Multiplication();
    Double expectedResult = 10.00;
    Double digitOne = 5.00;
    Double digitTwo = 2.00;
    String expected = "Multiplicación";

    @Test
    void operation() {
        Double result = multiplication.operation(digitOne, digitTwo);
        assertEquals(expectedResult, result, "Resultado de la Multiplicación es incorrecta");
    }

    @Test
    void description(){
        String text = multiplication.description();
        assertEquals(expected, text);
    }
}