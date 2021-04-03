package com.epam.junit.rule.customrule;

import org.junit.Rule;
import org.junit.Test;

import java.util.logging.Level;

public class LogTest {

    //Custom rule to check record attributes
    @Rule
    public LogTestingRule logRule = new LogTestingRule();

    @Test
    public void testNormalLog() {
        // Given
        LoggerClass underTest = new LoggerClass("myLogger");
        logRule.expect("myLogger", Level.INFO, "normal");
        // When
        underTest.logInfo();
        // Then
    }

    @Test
    public void testWithDifferentLogger() {
        // Given
        LoggerClass underTest = new LoggerClass("myLogger");
        logRule.expect("myLogger", Level.INFO, "normal");
        // When
        underTest.logInfo();
        // Then
    }

    @Test
    public void testErrorLog() {
        // Given
        LoggerClass underTest = new LoggerClass("myLogger");
        logRule.expect("myLogger", Level.SEVERE, "wrong");
        // When
        underTest.logError();
        // Then
    }

    @Test
    public void testNoExpectation() {
        LoggerClass underTest = new LoggerClass("myLogger");
        underTest.logInfo();
    }

}
