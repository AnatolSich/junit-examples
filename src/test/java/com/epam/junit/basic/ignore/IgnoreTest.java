package com.epam.junit.basic.ignore;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.fail;

//@Ignore("known bug")
public class IgnoreTest {

    @Test
    @Ignore("known bug")
    public void testFailing() {
        fail("failing");
    }

}
