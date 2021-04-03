package com.epam.junit.runner.theory;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(Theories.class)
public class MultipleDatapoint {

    @DataPoints
    public static int[] integers() {
        return new int[]{ -1, -10, -1234567, 1, 10, 1234567 };
    }

    @DataPoints
    public static String[] strings() {
        return new String[]{ "a", "b", "c" };
    }

    @DataPoint
    public static long longParameter() {
        return 99;
    }

    @Theory
    public void testAddition(Integer a, String b, long c) {
        System.out.println(a + " --- " + b + " --- " + c);
    }

}
