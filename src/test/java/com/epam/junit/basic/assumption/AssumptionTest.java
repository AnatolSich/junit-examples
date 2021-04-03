package com.epam.junit.basic.assumption;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.*;
public class AssumptionTest {

    // works with default runner
    @Test
    public void onlyRunsOnLinux() {
        assumeThat("not linux operating system, ignoring test", System.getProperty("os.name").toLowerCase(),
                containsString("linux"));
        assertTrue(true);
    }

    @Test
    public void onlyRunsOnWindows() {
        assumeThat("not windows operating system, ignoring test", System.getProperty("os.name").toLowerCase(),
                containsString("windows"));
        assertTrue(true);
    }
}
