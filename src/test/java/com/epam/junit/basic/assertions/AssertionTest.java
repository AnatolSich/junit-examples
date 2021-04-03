package com.epam.junit.basic.assertions;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class AssertionTest {

    @Test
    public void testWithEquals() {
        // Given
        // When
        String substring = "test".substring(1);
        // Then
        assertTrue(substring.equals("est"));
        assertEquals(substring, "est");
        assertThat(substring, equalTo("est"));
    }

    @Test
    public void testInstance() {
        // Given
        int[] first = new int[0];
        int[] second = new int[0];
        // When

        // Then
        assertTrue(first == first);
        assertSame(first, first);
        assertNotSame(first, second);
        assertThat(first, sameInstance(first));
        assertThat(first, instanceOf(int[].class));
    }

    @Test
    public void testArray() {
        // Given
        int[] first = new int[]{ 1, 2, 3 };
        int[] second = new int[]{ 1, 2, 3 };
        int[] third = new int[]{ 1, 2 };
        // When

        // Then
        assertTrue(Arrays.equals(first, second));
        assertArrayEquals(first, second);
    }

    @Test
    public void testList() {
        // Given
        List<Integer> items = Arrays.asList(1, 2, 3, 4, 5);
        // When

        // Then
        assertEquals(items, Arrays.asList(1, 2, 3, 4, 5));
        assertThat(items, everyItem(isA(Integer.class)));
        assertThat(items, hasItems(equalTo(1)));
    }

    @Test
    public void testString() {
        // Given
        String str = "this is a test string";
        // When

        // Then
        assertThat(str, containsString("is a test"));
        assertThat(str, startsWith("this"));
    }

    @Test
    public void testLogicalCombination() {
        // Given
        String str = "this is a test string";
        // When

        // Then
        assertThat(str, allOf(containsString("is a test"), startsWith("this")));
        assertThat(str, anyOf(startsWith("this"), startsWith("no")));
        assertThat(str, not(startsWith("no")));
    }

}
