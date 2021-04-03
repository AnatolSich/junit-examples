package com.epam.junit.rule.timeout;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class TimeoutRuleTest {

    //if any test run reaches time limit - it fails
    //rule is for all class
    @Rule
    public Timeout timeoutRule = Timeout.millis(100);

    @Test
    public void testTimeout1() throws InterruptedException {
        // Given

        // When
        Thread.sleep(1000);
        // Then

    }

    @Test
    public void testTimeout2() throws InterruptedException {
        // Given

        // When
        Thread.sleep(50);
        // Then

    }

    @Test
    public void testTimeout3() throws InterruptedException {
        // Given

        // When
        Thread.sleep(5);
        // Then

    }
}
