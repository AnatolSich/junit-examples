package com.epam.junit.runner.suite;

import com.epam.junit.runner.parameterized.ParameterizedTest;
import com.epam.junit.runner.parameterized.ZohhakParameterizedTest;
import com.epam.junit.runner.theory.MultipleDatapoint;
import com.epam.junit.runner.theory.TheoryTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ParameterizedTest.class, ZohhakParameterizedTest.class, TheoryTest.class, MultipleDatapoint.class})
public class RunnerTests {
}
