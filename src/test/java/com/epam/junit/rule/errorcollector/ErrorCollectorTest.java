package com.epam.junit.rule.errorcollector;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.fail;

public class ErrorCollectorTest {

    //Test will fail after first exception
    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            try {
                list.add(randomException());
            } catch (Exception exc) {
                fail("exception happened");
            }
        }
        System.out.println(list.size());
    }


    /*ErrorCollector rule - allows execution of a test to continue after the
     first problem is found (for example, to collect all the incorrect rows in a table)*/
    //can collect exceptions and evaluate them at the end of testing
    @Rule
    public ErrorCollector errorCollector = new ErrorCollector();

    @Test
    public void test2() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            try {
                list.add(randomException());
            } catch (Exception exc) {
                errorCollector.addError(exc);
            }
        }
        System.out.println(list.size());
    }

    private String randomException() {
        Random random = new Random();
        if (random.nextBoolean()) {
            throw new RuntimeException();
        }
        return "";
    }
}
