package com.epam.junit.runner.parameterized;

import com.epam.junit.NumberParser;
import com.googlecode.zohhak.api.DefaultCoercer;
import com.googlecode.zohhak.api.TestWith;
import com.googlecode.zohhak.api.runners.ZohhakRunner;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

//External com.googlecode.zohhak.api.runners.ZohhakRunner provides parameterized functionality
//Each test method will run depending on its @TestWith annotation configuration
@RunWith(ZohhakRunner.class)
public class ZohhakParameterizedTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private NumberParser numberParser = new NumberParser();

    //@TestWith annotation parses each string in array to params by separator and stringBoundary

    /*Optionally specify separator used to split parameters. It's a part of regexp so remember about escaping and special characters.
    If omitted, "," - (comma) is assumed.
      separator = ";"      -> ;
      separator = "\\|"    -> |
      separator = "[,;]"   -> , or ;
      separator = "=>"     -> =>
      */
    /* Special string to mark end string boundary. Will be removed during parsing but any surrounded characters will be preserved.
     Default is "'" (single quotation mark).

      stringBoundary   string before parse     string after parse
      "'"              "   abc     "           "abc"
      "'"              " ' abc '   "           " abc "
      "'"              " '' abc  ' "           "' abc  "
      "|"              " ' abc '   "           "' abc '"
      ""               " ' abc '   "           "' abc '"
    */

    //Test will run 4 times
    @TestWith(separator = "\\|", stringBoundary = "",value = {"0|0", "1|1", "2|2", "99|99"})
    public void testNumberParser(String input, int expected) {
        // Given

        // When
        int result = numberParser.parsePositiveNumber(input);
        // Then
        assertThat(result, equalTo(expected));
    }

    //Test will run 3 times
    @TestWith({"-1", "", "invalid"})
    public void testErrorCase(String input) {
        // Given
        expectedException.expect(RuntimeException.class);
        // When
        int result = numberParser.parsePositiveNumber(input);
        // Then

    }

    //Coercers - parsers params from String to other types
    //Test will run 2 times
    //This test will run next test with similar name
    @TestWith(value = {"[1;2;3]", "[3;4]"}, coercers = {DefaultCoercer.class, CustomCoercer.class})
    public void testWithInteger(Integer[] array) {
        System.out.println("sizeArray = " + array.length);
        // Given
        Arrays.asList(array).forEach(System.out::println);
        // When

        // Then
    }

    //Test will run 2 times
    //This test will run previous test with similar name
    @TestWith(value = {"[1;2;3]", "[3;4]"}, coercers = {DefaultCoercer.class, CustomCoercer.class})
    public void testWithInteger(List<Integer> list) {
        System.out.println("sizeList = " + list.size());
        // Given
        Arrays.asList(list).forEach(System.out::println);
        // When

        // Then
    }
    //Test will run 2 times
    @TestWith(value = {"[true;false;true]", "[false;true]"}, coercers = {DefaultCoercer.class, CustomCoercer.class})
    public void testWithBooleanArray(Boolean[] array) {
        System.out.println("size = " + array.length);
        // Given
        Arrays.asList(array).forEach(System.out::println);
        // When

        // Then

    }



    //Test will run only 1 time
    @Test
    public void testOnceOnly() {
        System.out.println("test");
    }

}
