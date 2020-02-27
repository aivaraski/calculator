package com.example.demo;

public class DataValidation {
    public static String FAIL_CAUSE;

    public static void verifyAllArgsArePresent(final String[] args) {
        if (args == null){
            throw new IllegalArgumentException("Received null as arguments");
        }
        else if (args.length != 3) {
            throw new IllegalArgumentException("Not all or to many arguments are present");
        }
    }

    public static boolean performArgumentsValidation(final String arg1, final String arg2, final String arg3) {
        return verifyInteger(arg1) &&
                verifyInteger(arg2) &&
                verifyOperator(arg3);
    }

    public static boolean verifyNoDivisionByZero(final String secondInteger, final String operator) {
        if (!(operator.equals("/") && secondInteger.equals("0"))) {
            return true;
        } else {
            FAIL_CAUSE = "Really? trying to divide by zero?";
            return false;
        }
    }

    private static boolean verifyInteger(final String arg) {
        try {
            Integer.valueOf(arg);
            return true;
        } catch (Exception e) {
            FAIL_CAUSE = arg + " is not a valid integer";
            return false;
        }
    }

    private static boolean verifyOperator(final String operator) {
        if (operator.equals("/") || operator.equals("*") || operator.equals("-") || operator.equals("+"))
            return true;
        else {
            FAIL_CAUSE = operator + " is not a valid operator";
            return false;
        }
    }
}
