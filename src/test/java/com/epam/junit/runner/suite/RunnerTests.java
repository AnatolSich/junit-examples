package com.epam.junit.runner.suite;

import com.epam.junit.runner.parameter.ParameterTest;
import com.epam.junit.runner.parameter.ZohhakTest;
import com.epam.junit.runner.theory.MultipleDatapoint;
import com.epam.junit.runner.theory.TheoryTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ParameterTest.class, ZohhakTest.class, TheoryTest.class, MultipleDatapoint.class })
public class RunnerTests {
}
