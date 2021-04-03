package com.epam.junit.runner.parameter;

import com.epam.junit.NumberParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class ParameterTest {

    @Parameterized.Parameters(name = "test for {0} + {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{ { "0", 0 }, { "1", 1 }, { "2", 2 }, { "99", 99 } });
    }

    @Parameterized.Parameter
    // default is 0
    public String input;

    @Parameterized.Parameter(1)
    public int expected;

    private NumberParser numberParser = new NumberParser();

    @Test
    public void testNumberParser() {
        // Given

        // When
        int result = numberParser.parsePositiveNumber(input);
        // Then
        assertThat(result, equalTo(expected));
    }

    @Test
    public void testSysout() {
        System.out.println(input + expected);
    }

}
