package com.example.demo;

public class Calculations {
    private static final String FAIL_MESSAGE = "Error on doing operation: ";

    public static void runCalculator(final String[] args) {
        DataValidation.verifyAllArgsArePresent(args);

        final String arg1 = args[0];
        final String arg2 = args[1];
        final String arg3 = args[2];

        if (argumentsAreValid(arg1, arg2, arg3) && noDivisionByZero(arg2, arg3)) {
            String argumentsWithCalculationResult = calculateAndPrepareAnswer(arg1, arg2, arg3);
            System.out.println(argumentsWithCalculationResult);
        } else {
            System.out.println(FAIL_MESSAGE + DataValidation.FAIL_CAUSE);
        }
    }

    private static String calculateAndPrepareAnswer(final String integer1, final String integer2, final String operator) {
        Integer firstInteger = Integer.valueOf(integer1);
        Integer secondInteger = Integer.valueOf(integer2);

        String resultValue = doCalculations(firstInteger, secondInteger, operator);

        return firstInteger + " " + operator + " " + secondInteger + " = " + resultValue;
    }

    private static String doCalculations(final Integer firstInteger, final Integer secondInteger, final String operator) {
        long longFirstInteger = Long.valueOf(firstInteger);
        long longSecondInteger = Long.valueOf(secondInteger);
        if (operator.equals("/")) {
            return String.valueOf(firstInteger / (double) secondInteger);
        } else if (operator.equals("*")) {
            return String.valueOf(longFirstInteger * longSecondInteger);
        } else if (operator.equals("+")) {
            return String.valueOf(longFirstInteger + longSecondInteger);
        } else if (operator.equals("-")) {
            return String.valueOf(longFirstInteger - longSecondInteger);
        }
        else throw new IllegalArgumentException("illegal argument reached calculations");
    }

    private static boolean argumentsAreValid(final String integer1, final String integer2, final String operator) {
        return DataValidation.performArgumentsValidation(integer1, integer2, operator);
    }

    private static boolean noDivisionByZero(final String integer2, final String operator) {
        return DataValidation.verifyNoDivisionByZero(integer2, operator);
    }
}
