package com.epam.junit;

//Parser for only positive number for exception testing
//can throw RuntimeException with different messages

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
