package com.epam.junit.rule.errorcollector;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ErrorCollectorTest {



    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        for(int i=0;i<100;i++) {
            try{
                list.add(randomException());
            } catch (Exception exc){
                fail("exception happened");
            }
        }
        System.out.println(list.size());
    }

    @Rule
    public ErrorCollector errorCollector =
            new ErrorCollector();

    @Test
    public void test2() {
        List<String> list = new ArrayList<>();
        for(int i=0;i<100;i++) {
            try{
                list.add(randomException());
            } catch (Exception exc){
                errorCollector.addError(exc);
            }
        }
        System.out.println(list.size());
    }

    private String randomException() {
        Random random = new Random();
        if(random.nextBoolean()){
            throw new RuntimeException();
        }
        return "";
    }
}
