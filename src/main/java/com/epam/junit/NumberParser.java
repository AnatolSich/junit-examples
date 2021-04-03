package com.epam.junit;

public class NumberParser {

    public int parsePositiveNumber(String number) {
        try {
            int result = Integer.parseInt(number);
            if (result < 0) {
                throw new RuntimeException("negative number");
            }
            return result;
        } catch (NumberFormatException exc) {
            throw new RuntimeException("invalid number format");
        }

    }

}
