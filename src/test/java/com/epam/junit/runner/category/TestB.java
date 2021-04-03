package com.epam.junit.runner.category;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({MyCategories.ControllerTest.class, MyCategories.DatabaseTest.class})
public class TestB {
    @Test
    public void test3() {
        System.out.println("database and controller test");
    }
}
