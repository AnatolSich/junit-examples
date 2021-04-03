package com.epam.junit.rule.testwatcher;

import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.AssumptionViolatedException;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;

public class TestWatcherTest {

    //TestWatcher - base class for Rules that take note of the testing action, without modifying it
    //TestWatcher rule - defines behavior for different test events
    @Rule
    public TestWatcher testWatcher = new TestWatcher() {
        @Override
        protected void succeeded(Description description) {
            System.out.println("succeeded");
        }

        @Override
        protected void failed(Throwable e, Description description) {
            System.out.println("failed");
        }

        @Override
        protected void skipped(AssumptionViolatedException e, Description description) {
            System.out.println("skipped");
        }

        @Override
        protected void starting(Description description) {
            System.out.println("starting");
        }

        @Override
        protected void finished(Description description) {
            System.out.println("finished");
        }
    };

    @Test
    public void succeeded() {

    }

    @Test
    public void failed() {
        fail();
    }

    @Test
    public void skip() {
        assumeFalse(true);
    }

}
