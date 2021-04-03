package com.epam.junit.runner.theory;

import org.junit.Assume;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(Theories.class)
public class TheoryTest {

    @DataPoints
    public static int[] negative() {
        return new int[]{-1, -10, -1234567, -3, -50};
    }

    @DataPoints
    public static int[] positive() {
        return new int[]{1, 10, 3, 8, 999, 1234567};
    }

    /*TheoryTest will attempt to run testAddition() on every compatible data point defined in the class.
    If any of the assumptions fail, the data point is silently ignored.
    If all of the assumptions pass, but an assertion fails, the test fails.*/
    // Only wrapper (Object) type as parameters
    //11*11=121 possible combinations will be run
    @Theory
    public void testAddition(Integer a, Integer b) {
        Assume.assumeTrue(a > 0 && b > 0);
        System.out.println(a + " - " + b);
        assertTrue(a + b > a);
        assertTrue(a + b > b);
    }

    @Theory
    public void testAdditionIsCommutative(int a, int b) {
        System.out.println(a + b == b + a);
        assertTrue(a + b == b + a);
    }

}
