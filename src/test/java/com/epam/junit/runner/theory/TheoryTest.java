package com.epam.junit.runner.theory;
import org.junit.Assume;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeThat;

@RunWith(Theories.class)
public class TheoryTest {

    @DataPoints
    public static int[] negative() {
        return new int[]{ -1, -10, -1234567, -3, -50 };
    }

    @DataPoints
    public static int[] positive() {
        return new int[]{ 1, 10, 3, 8, 999, 1234567 };
    }

    // only wrapper type as parameter
    @Theory
    public void testAddition(Integer a, Integer b) {
        Assume.assumeTrue(a > 0 && b > 0);
        System.out.println(a + " - " + b);
        assertTrue(a + b > a);
        assertTrue(a + b > b);
    }

    @Theory
    public void testAdditionIsCommutative(Integer a, Integer b) {
        assertTrue(a + b == b + a);
    }

}
