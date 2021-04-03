package com.epam.junit.basic.custommatcher;

import org.junit.Test;

import static com.epam.junit.basic.custommatcher.PalindromeMatcher.isAPalindrome;
import static com.epam.junit.basic.custommatcher.PalindromeMatcher.isNotAPalindrome;
import static org.junit.Assert.assertThat;

public class CustomMatcherTest {

    @Test
    public void testWithValidPalindrome() {
        // Given
        String palindrome = "racecar";
        // When
        // Then
        assertThat(palindrome, isAPalindrome());
    }

    @Test
    public void testWithValidPalindromeFail() {
        // Given
        String palindrome = "racecar2";
        // When
        // Then
        assertThat(palindrome, isAPalindrome());
    }

    @Test
    public void testWithInvalidPalindrome() {
        // Given
        String palindrome = "invalid";
        // When
        // Then
        assertThat(palindrome, isNotAPalindrome());
    }

    @Test
    public void testWithInvalidPalindromeFail() {
        // Given
        String palindrome = "validdilav";
        // When
        // Then
        assertThat(palindrome, isNotAPalindrome());
    }

}
