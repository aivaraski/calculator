package com.example.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class CalculationsTest {
    private PrintStream originalSystemOut;
    private ByteArrayOutputStream systemOutContent;

    @BeforeEach
    void redirectSystemOutStream() {

        originalSystemOut = System.out;

        systemOutContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(systemOutContent));
    }

    @AfterEach
    void restoreSystemOutStream() {
        System.setOut(originalSystemOut);
    }

    @Test
    void divisionByZeroReturnsCorrectError() {
        Calculations.runCalculator(new String[]{"7", "0", "/"});
        Assertions.assertEquals("Really? trying to divide by zero?", DataValidation.FAIL_CAUSE, "Fail cause message was incorrect");
    }

    @Test
    void providingBadIntegerProvidesCorrectErrorMessage() {
        Calculations.runCalculator(new String[]{"7", "T", "/"});
        Assertions.assertEquals("T is not a valid integer", DataValidation.FAIL_CAUSE, "Fail cause message was incorrect");
    }

    @Test
    void providingBadOperatorProvidesCorrectErrorMessage() {
        Calculations.runCalculator(new String[]{"7", "7", "!"});
        Assertions.assertEquals("Error on doing operation: ! is not a valid operator", systemOutContent.toString().replaceAll("\\n+", ""), "Fail message with bad operator was incorrect");
    }

    @Test
    void divisionReturnsCorrectAnswer() {
        Calculations.runCalculator(new String[]{"7", "7", "/"});
        Assertions.assertEquals("7 / 7 = 1.0", systemOutContent.toString().replaceAll("\\n+", ""), "Division outcome/message was incorrect");
    }

    @Test
    void subtractionReturnsCorrectAnswer() {
        Calculations.runCalculator(new String[]{"10", "100", "-"});
        Assertions.assertEquals("10 - 100 = -90", systemOutContent.toString().replaceAll("\\n+", ""), "Subtraction outcome/message was incorrect");
    }

    @Test
    void additionReturnsCorrectAnswer() {
        Calculations.runCalculator(new String[]{"-100", "-500", "+"});
        Assertions.assertEquals("-100 + -500 = -600", systemOutContent.toString().replaceAll("\\n+", ""), "Addition outcome/message was incorrect");
    }

    @Test
    void multiplicationReturnsCorrectAnswer() {
        Calculations.runCalculator(new String[]{"-10", "-10", "*"});
        Assertions.assertEquals("-10 * -10 = 100", systemOutContent.toString().replaceAll("\\n+", ""), "Multiplication outcome/message was incorrect");
    }
}
