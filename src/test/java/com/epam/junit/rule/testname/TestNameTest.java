package com.epam.junit.rule.testname;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class TestNameTest {

    @Rule
    public TestName testName = new TestName();

    @Test
    public void testWithSpecialName() {
        System.out.println(testName.getMethodName());
    }
}
