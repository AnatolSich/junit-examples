package com.epam.junit.rule.testmethodname;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class TestNameTest {

    //must be public field in test class

    //TestName Rule - makes the current test name available inside test methods
    //Method getMethodName() - implemented in TestName Rule
    @Rule
    public TestName testName = new TestName();

    @Test
    public void testWithSpecialName() {
        System.out.println(testName.getMethodName());
    }
}
