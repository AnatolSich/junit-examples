package com.epam.junit.runner.suite;

import com.epam.junit.basic.assertions.AssertionTest;
import com.epam.junit.basic.assertions.FailingTest;
import com.epam.junit.basic.assumption.AssumptionBeforeTest;
import com.epam.junit.basic.assumption.AssumptionTest;
import com.epam.junit.basic.fixtures.FixtureTest;
import com.epam.junit.basic.ignore.IgnoreTest;
import com.epam.junit.basic.testorder.TestOrder;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/*Runner handles things related to before/after and rules
* Default runner - BlockJUnit4ClassRunner
* annotation @RunWith on class - can override the runner*/

/*Suite - a runner allows you to manually
 * build a suite containing tests from many classes*/
//if test class is in several suits, it will runs multiple times
@RunWith(Suite.class)
@Suite.SuiteClasses({AssertionTest.class, FailingTest.class, AssumptionTest.class, AssumptionBeforeTest.class, FixtureTest.class, TestOrder.class,
        TestOrder.class, IgnoreTest.class})
public class BasicTests {
}
