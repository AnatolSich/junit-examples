package com.epam.junit.basic.assertions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class FailingTest {

    @Test
    public void testWithoutMessage() {
        //Given
        int expectedId = 3;
        //When
        int actualId = Integer.parseInt("2");
        //Then
        assertEquals(expectedId, actualId);
    }

    @Test
    public void testWithMessage() {
        //Given
        int expectedId = 3;
        //When
        int actualId = Integer.parseInt("2");
        //Then
        assertEquals("id is different", expectedId, actualId);
    }

    @Test
    public void failWithoutMessage() {
        //Given

        //When
        fail();
        //Then

    }

    @Test
    public void failWithMessage() {
        //Given

        //When
        fail("this is an intentional fail");
        //Then

    }

}
