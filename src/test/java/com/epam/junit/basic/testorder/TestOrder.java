package com.epam.junit.basic.testorder;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;

@FixMethodOrder(MethodSorters.JVM)
public class TestOrder {

    // @Test
    public void renameMe() {
        Arrays.stream(this.getClass().getDeclaredMethods()).forEach(System.out::println);
    }

    @Test
    public void a() {
        System.out.println("a");
    }

    @Test
    public void c() {
        System.out.println("c");
    }

    @Test
    public void b() {
        System.out.println("b");
    }

}
