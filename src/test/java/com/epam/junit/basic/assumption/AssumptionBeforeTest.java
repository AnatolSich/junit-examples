package com.epam.junit.basic.assumption;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assume.assumeThat;
public class AssumptionBeforeTest {

    @Before
    public void setup() {
        assumeThat(System.getProperty("os.name").toLowerCase(), containsString("linux"));
    }

    @Test
    public void test1() {
        assertTrue(true);
    }

    @Test
    public void test2() {
        assertTrue(true);
    }
}
