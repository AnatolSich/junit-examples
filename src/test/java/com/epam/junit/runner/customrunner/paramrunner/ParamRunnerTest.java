package com.epam.junit.runner.customrunner.paramrunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(ParamRuner.class)
public class ParamRunnerTest {

    @Test
    public void test() {
        // Given

        // When

        // Then
        assertThat(1, equalTo(1));
    }

    @Test
    @TestAnnotation({ 2, 3, 4, 0 })
    public void test2(int a) {
        // Given

        // When
        System.out.println(a);
        // Then
    }

}
