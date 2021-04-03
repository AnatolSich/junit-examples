package com.epam.junit.rule.timeout;

import org.junit.Test;

public class TimeoutTest {

    private static final int TIMEOUT = 100;

    @Test(timeout = TIMEOUT)
    public void testTimeout1() throws InterruptedException {
        // Given

        // When
        Thread.sleep(1000);
        // Then

    }

    @Test(timeout = TIMEOUT)
    public void testTimeout2() throws InterruptedException {
        // Given

        // When
        Thread.sleep(50);
        // Then

    }

    @Test(timeout = TIMEOUT)
    public void testTimeout3() throws InterruptedException {
        // Given

        // When
        Thread.sleep(5);
        // Then

    }

}
