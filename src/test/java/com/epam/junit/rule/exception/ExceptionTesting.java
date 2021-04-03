package com.epam.junit.rule.exception;

import com.epam.junit.NumberParser;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ExceptionTesting {

    private NumberParser underTest = new NumberParser();

    @Test
    public void testParsePositiveNumberWithValidNumber() {
        // Given
        // When
        int parse = underTest.parsePositiveNumber("1");
        // Then
        assertThat(parse, equalTo(1));
    }

    //First approach to test exceptions
    //Only by it type
    @Test(expected = RuntimeException.class)
    public void testParsePositiveNumberWithInvalidNumber() {
        // Given
        // When
        int parse = underTest.parsePositiveNumber("invalid");
        // Then
        // exception is thrown, no check below this
        assertTrue(true);
    }

    @Test(expected = RuntimeException.class)
    public void testParsePositiveNumberWithNegativeNumber() {
        // Given
        // When
        int parse = underTest.parsePositiveNumber("-01");
        // Then
        // exception is thrown
    }

    //Second approach to test exceptions
    //By using try/catch with checking the messages in assert
    //Need to add fail() after method invocation in case no exception thrown (fake positive test)
    @Test
    public void testParsePositiveNumberWithNegativeNumber2() {
        // Given
        // When
        try {
            int parse = underTest.parsePositiveNumber("-01");
            fail("no exception is thrown");
        } catch (RuntimeException exc) {
            assertThat(exc, instanceOf(RuntimeException.class));
            assertThat(exc.getMessage(), equalTo("negative number"));
        }
        // Then
        // exception is thrown
    }

    //Third approach to exception testing
    //Checks for types and message and no need to add fail()

    //ExpectedException rule allows to verify that your code throws a specific exception
    //none() - returns a rule that expects no exception to be thrown
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testParsePositiveNumberWithNegativeNumber3() {
        // Given
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("negative number");
        // When
        int parse = underTest.parsePositiveNumber("-01");
        // Then
        // exception is thrown
    }
}
