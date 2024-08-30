package org.douglasalvarado.clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestTest {

    Rest rest = new Rest();
    Double expectedResult = 5.00;
    Double digitOne = 10.00;
    Double digitTwo = 5.00;
    String expected = "Resta";

    @Test
    void operation() {
        Double result = rest.operation(digitOne, digitTwo);
        assertEquals(expectedResult, result, "Resultado de la Resta es incorrecta");
    }

    @Test
    void description(){
        String text = rest.description();
        assertEquals(expected, text);
    }
}