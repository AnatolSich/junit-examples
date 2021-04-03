package com.epam.junit.runner.theory;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

/* Theories runner allows to test a certain functionality against a subset of an infinite set of data points.
The Theories runner executes your test method as many times as the number of data points declared, providing a different data point as
the input argument on each invocation.
* */
@RunWith(Theories.class)
public class MultipleDatapoint {

    @DataPoints
    public static int[] integers() {
        return new int[]{-1, -10, -1234567, 1, 10, 1234567};
    }

    @DataPoints
    public static String[] strings() {
        return new String[]{"a", "b", "c"};
    }

    @DataPoint
    public static long longParameter() {
        return 99;
    }

    //Theory is a piece of functionality (a method) that is executed against several data inputs called data points.
    //It runs every possible parameters combination (18 in this case)
    @Theory
    public void testAddition(Integer a, String b, long c) {
        System.out.println(a + " --- " + b + " --- " + c);
    }

}
