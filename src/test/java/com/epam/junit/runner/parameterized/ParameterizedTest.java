package com.epam.junit.runner.parameterized;

import com.epam.junit.NumberParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

//The custom runner Parameterized implements parameterized tests.
/*Each instance of ParameterizedTest will be constructed using the
 * two-argument constructor and the data values in the
 * @Parameters method.*/
@RunWith(Parameterized.class)
public class ParameterizedTest {

    /*To identify the particular test, you may provide a
     * name for the @Parameters annotation. This name is allowed
     * to contain placeholders, which are replaced at runtime. The placeholders are:
     *{index} - the current parameter index
     * {0} - the first parameter value
     * {1} - the second parameter value
     * ... */

    /*For single parameter testing case:
    public static Iterable <? extends Object> data() {
     	return Arrays.asList("first test", "second test");
     }

     public static Object[] data() {
     	return new Object[] { "first test", "second test" };
      }*/
    @Parameterized.Parameters(name = "test number {index} for: param1 = {0} and param2 = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{{"0", 0}, {"1", 1}, {"2", 2}, {"99", 99}});
    }

    @Parameterized.Parameter(0)
    // default parameter value is 0
    public String input;

    @Parameterized.Parameter(1)
    public int expected;

    private NumberParser numberParser = new NumberParser();

    //This test will run for each element from @Parameters collection
    @Test
    public void testNumberParser() {
        // Given

        // When
        int result = numberParser.parsePositiveNumber(input);
        // Then
        assertThat(result, equalTo(expected));
    }

    //This test will run for each element from @Parameters collection
    @Test
    public void testSysOut() {
        System.out.println("input = " + input + " expected = " + expected);
    }

}
