package com.epam.junit.runner.customrunner.paramsfromannotationrunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

//Test class to demonstrate custom runner for using params from annotation
@RunWith(UseOwnParamsRunner.class)
public class UseOwnParamsRunnerTest {

    @Test
    public void test() {
        // Given

        // When

        // Then
        assertThat(1, equalTo(1));
    }

    @Test
    @OwnParamsAnnotation({2, 3, 4, 0})
    public void test2(int a) {
        // Given

        // When
        System.out.println(a);
        // Then
    }

}
