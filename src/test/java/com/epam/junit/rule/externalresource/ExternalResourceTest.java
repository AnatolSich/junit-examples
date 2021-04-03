package com.epam.junit.rule.externalresource;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;

public class ExternalResourceTest {

    @ClassRule
    public static ExternalResource classExternalResource = new ExternalResource() {
        @Override
        protected void before() throws Throwable {
            System.out.println("opening major resource");
        }

        @Override
        protected void after() {
            System.out.println("closing major resource");
        }
    };

    @Rule
    public ExternalResource externalResource = new ExternalResource() {
        @Override
        protected void before() throws Throwable { System.out.println("opening resource"); }

        @Override
        protected void after() {
            System.out.println("closing resource");
        }
    };

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }
}
