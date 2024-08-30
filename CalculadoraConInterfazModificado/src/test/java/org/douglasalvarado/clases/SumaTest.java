package org.douglasalvarado.clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumaTest {

    Suma suma = new Suma();
    String expected = "Suma";
    Double expectedResult = 15.00;
    Double digitOne = 8.00;
    Double digitTwo = 7.00;

    @Test
    void operation() {
        Double result = suma.operation(digitOne, digitTwo);
        assertEquals(expectedResult, result , "Resultado de la Suma es incorrecta");
    }

    @Test
    void description(){
        String text = suma.description();
        assertEquals(expected, text);
    }
}