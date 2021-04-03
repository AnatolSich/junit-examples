package com.epam.junit.runner.parameter;
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

@RunWith(ZohhakRunner.class)
public class ZohhakTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private NumberParser numberParser = new NumberParser();

    @TestWith(value = { "0,0", "1,1", "2,2", "99,99" })
    public void testNumberParser(String input, int expected) {
        // Given

        // When
        int result = numberParser.parsePositiveNumber(input);
        // Then
        assertThat(result, equalTo(expected));
    }

    @TestWith({ "-1", "", "invalid" })
    public void testErrorCase(String input) {
        // Given
        expectedException.expect(RuntimeException.class);
        // When
        int result = numberParser.parsePositiveNumber(input);
        // Then

    }

    @TestWith(value = { "[1;2;3]", "[3;4]" }, coercers = { DefaultCoercer.class, CustomCoercer.class })
    public void testWithList(Integer[] list) {
        // Given
        Arrays.asList(list).forEach(System.out::println);
        // When

        // Then

    }

    @TestWith(value = { "[true;false;true]", "[false;true]" }, coercers = { DefaultCoercer.class, CustomCoercer.class })
    public void testWithArray(Boolean[] list) {
        // Given
        Arrays.asList(list).forEach(System.out::println);
        // When

        // Then

    }

    @TestWith(value = { "[1;2;3]", "[3;4]" }, coercers = { DefaultCoercer.class, CustomCoercer.class })
    public void testWithList(List<Integer> list) {
        // Given
        Arrays.asList(list).forEach(System.out::println);
        // When

        // Then

    }

    @Test
    public void testOnceOnly() {
        System.out.println("test");
    }

}
