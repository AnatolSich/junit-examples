package com.epam.junit.runner.category;

import org.junit.Test;
import org.junit.experimental.categories.Category;

//Test can be categorised with @Category (any class or interface)
//One test can have many categories
public class TestA {

    @Test
    @Category({MyCategories.DatabaseTest.class, MyCategories.MyOwnCategory.class})
    public void test1() throws InterruptedException {
        System.out.println("database test");
    }

    @Test
    @Category(MyCategories.ControllerTest.class)
    public void test2() {
        System.out.println("controller test");
    }

}
