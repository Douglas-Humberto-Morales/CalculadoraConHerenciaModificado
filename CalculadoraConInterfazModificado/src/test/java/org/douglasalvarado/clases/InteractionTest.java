package org.douglasalvarado.clases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
class InteractionTest {

    Double digitOne = 10.00;
    Double digitTwo = 5.00;
    Double resultExpected;
    String optionFalse = "N";
    String optionTrue = "Y";
    String optionFalseLowerCase = "N";
    String optionTrueLowerCase = "Y";
    String optionError = "X";
    String sign;

    //Mock: Hace una simulacion de la clase
    @Mock
    private Suma suma;

    @Mock
    private Rest rest;

    @Mock
    private Multiplication multiplication;

    @Mock
    private Division division;

    @Mock
    private Scanner scanner;

    // InjectMocks: Esto inyecta los mocks en una
    // instancia de la clase Interaction, reemplazando
    // las instancias reales con las simuladas.
    @InjectMocks
    private Interaction interaction;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void options() {
        when(scanner.nextLine()).thenReturn("1");
        interaction.options();
    }

    @Test
    void selection() {
        when(scanner.nextDouble()).thenReturn(digitOne, digitTwo);
        interaction.selection();
    }

    @Test
    void testOperationSuma() {
        resultExpected = 15.00;
        sign = "+";
        when(scanner.nextLine()).thenReturn(sign);
        when(suma.operation(digitOne, digitTwo)).thenReturn(resultExpected);
        interaction.setAmountOne(digitOne);
        interaction.setAmountTwo(digitTwo);
        interaction.setSignOperate(sign);

        Double result = interaction.operation();
        assertEquals(resultExpected, result);
    }

    @Test
    void testOperationRest() {
        resultExpected = 5.00;
        sign = "-";
        when(scanner.nextLine()).thenReturn(sign);
        when(rest.operation(digitOne, digitTwo)).thenReturn(resultExpected);
        interaction.setAmountOne(digitOne);
        interaction.setAmountTwo(digitTwo);
        interaction.setSignOperate(sign);

        Double result = interaction.operation();
        assertEquals(resultExpected, result);
    }

    @Test
    void testOperationMultiplication() {
        resultExpected = 50.00;
        sign = "*";
        when(scanner.nextLine()).thenReturn(sign);
        when(multiplication.operation(digitOne, digitTwo)).thenReturn(resultExpected);
        interaction.setAmountOne(digitOne);
        interaction.setAmountTwo(digitTwo);
        interaction.setSignOperate(sign);

        Double result = interaction.operation();
        assertEquals(resultExpected, result);
    }

    @Test
    void testOperationDivision() {
        resultExpected = 2.00;
        sign = "/";
        when(scanner.nextLine()).thenReturn(sign);
        when(division.operation(digitOne, digitTwo)).thenReturn(resultExpected);
        interaction.setAmountOne(digitOne);
        interaction.setAmountTwo(digitTwo);
        interaction.setSignOperate(sign);

        Double result = interaction.operation();
        assertEquals(resultExpected, result);
    }

    @Test
    void testInvalidOperation() {
        sign = "%";
        when(scanner.nextLine()).thenReturn(sign);
        interaction.setAmountOne(digitOne);
        interaction.setAmountTwo(digitTwo);
        interaction.setSignOperate(sign);

        Double result = interaction.operation();
        assertNull(result);
    }

    @Test
    void textToReturn() {
        String result = interaction.textToReturn(digitOne);
        assertEquals("El resultado es: 10.0", result);
    }

    @Test
    void textToReturnNull() {
        String result = interaction.textToReturn(null);
        assertEquals("Seleecion no valida", result);
    }

    @Test
    void continuerTheProcessesY() {
        when(scanner.nextLine()).thenReturn(optionTrue);
        interaction.continuerTheProcesses();

        when(scanner.nextLine()).thenReturn(optionTrueLowerCase);
        interaction.continuerTheProcesses();
    }

    @Test
    void continuerTheProcessesN() {
        when(scanner.nextLine()).thenReturn(optionFalse);
        interaction.continuerTheProcesses();

        when(scanner.nextLine()).thenReturn(optionFalseLowerCase);
        interaction.continuerTheProcesses();
    }

    @Test
    void continuerTheProcessesOther() {
        when(scanner.nextLine()).thenReturn(optionError,optionFalseLowerCase);
        Boolean result = interaction.continuerTheProcesses();
        assertFalse(result);
    }

    @Test
    void combination() {
        sign = "+";
        when(scanner.nextLine()).thenReturn(sign,optionFalse);
        when(scanner.nextDouble()).thenReturn(digitOne, digitTwo);
        interaction.combination();
    }

    @Test
    void combinationContinue() {
        sign = "+";
        when(scanner.nextLine()).thenReturn(sign,optionTrue,sign,optionFalse);
        when(scanner.nextDouble()).thenReturn(digitOne, digitTwo);
        interaction.combination();
    }
}