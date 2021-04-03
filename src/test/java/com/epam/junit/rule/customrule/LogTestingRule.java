package com.epam.junit.rule.customrule;

import org.junit.rules.Verifier;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/*To create new rule you need to implement TestRule interface or extend any of its implementation
provided by JUnit:
ErrorCollector: collect multiple errors in one test method
ExpectedException: make flexible assertions about thrown exceptions
ExternalResource: start and stop a server, for example
TemporaryFolder: create fresh files, and delete after test
TestName: remember the test name for use during the method
TestWatcher: add logic at events during method execution
Timeout: cause test to fail after a set time
Verifier: fail test if object state ends up incorrect*/

/*Verifier is a base class for Rules like ErrorCollector, which can turn
 passing test methods into failing tests if a verification check is failed*/
//we overrode verify() for checking loggerName, record level and record message of every record
public class LogTestingRule extends Verifier {

    private MockHandler mockHandler;

    private List<LogRecord> expectedLogRecordsAfterTest = new ArrayList<>();

    public LogTestingRule() {
        this.mockHandler = new MockHandler();
        Logger logger = Logger.getLogger("");
        logger.addHandler(mockHandler);
    }

    public void expect(String loggerName, Level level, String message) {
        LogRecord e = new LogRecord(level, message);
        e.setLoggerName(loggerName);
        expectedLogRecordsAfterTest.add(e);
    }

    @Override
    protected void verify() throws Throwable {
        expectedLogRecordsAfterTest.forEach(logRecord -> {
            if (!mockHandler.containsLogEvent(logRecord)) {
                String message = String.format("Missing log. Name: %s Level: %s, message fragment: %s",
                        logRecord.getLoggerName(), logRecord.getLevel(), logRecord.getMessage());
                throw new AssertionError(message);
                //AssertionError usually throws to indicate that an assertion has failed.
            }
        });
    }

    /*Handler object takes log messages from a Logger and
     * exports them.  It might for example, write them to a console
     * or write them to a file*/
    static class MockHandler extends Handler {

        private List<LogRecord> logRecords = new ArrayList<>();

        @Override
        public void publish(LogRecord record) {
            logRecords.add(record);
        }

        @Override
        public void flush() {

        }

        @Override
        public void close() throws SecurityException {

        }

        public boolean containsLogEvent(LogRecord expectedLogRecord) {
            return logRecords.stream().anyMatch(
                    logRecord -> logRecord.getLoggerName().equals(expectedLogRecord.getLoggerName())
                            && logRecord.getLevel().equals(expectedLogRecord.getLevel())
                            && logRecord.getMessage().contains(expectedLogRecord.getMessage()));
        }
    }
}
