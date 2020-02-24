package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DataValidationTest {
    @Test
    void readParametersWhenInvalidNumberOfArguments() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> DataValidation.verifyAllArgsArePresent(new String[] {}));
        Assertions.assertEquals("Not all or to many arguments are present", exception.getMessage(), "Incorrect error message received");
    }

    @Test
    void dividingByZeroReturnsFalse() {
        boolean returnDividingByZero = DataValidation.verifyNoDivisionByZero("0", "/");
        Assertions.assertFalse(returnDividingByZero, "Division by zero did not return false");
    }

    @Test
    void multiplyingByZeroReturnsTrue() {
        boolean returnMultiplicationByZero = DataValidation.verifyNoDivisionByZero("0", "*");
        Assertions.assertTrue(returnMultiplicationByZero, "Multiplication by zero did not return true");
    }

    @Test
    void firstArgumentNotIntegerReturnsFalse() {
        boolean returnOfNotAnInteger = DataValidation.performArgumentsValidation("s", "8", "/");
        Assertions.assertFalse(returnOfNotAnInteger, "Should return false if first argument is not an integer");
    }

    @Test
    void secondArgumentNotIntegerReturnsFalse() {
        boolean returnOfNotAnInteger = DataValidation.performArgumentsValidation("8", "-", "/");
        Assertions.assertFalse(returnOfNotAnInteger, "Should return false if second argument is not an integer");
    }

    @Test
    void thirdArgumentNotValidOperatorReturnsFalse() {
        boolean returnOfNotAnInteger = DataValidation.performArgumentsValidation("8", "4", "=");
        Assertions.assertFalse(returnOfNotAnInteger, "Should return false if third argument is not a valid operator");
    }
}
