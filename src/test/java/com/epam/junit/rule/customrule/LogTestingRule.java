package com.epam.junit.rule.customrule;

import org.junit.rules.Verifier;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
public class LogTestingRule extends Verifier {

    private MockHandler mockHandler;

    private List<LogRecord> expect = new ArrayList<>();

    public LogTestingRule() {
        this.mockHandler = new MockHandler();
        Logger logger = Logger.getLogger("");
        logger.addHandler(mockHandler);
    }

    public void expect(String loggername, Level level, String message) {
        LogRecord e = new LogRecord(level, message);
        e.setLoggerName(loggername);
        expect.add(e);
    }

    @Override
    protected void verify() throws Throwable {
        expect.forEach(logRecord -> {
            if (!mockHandler.containsLogEvent(logRecord)) {
                String message = String.format("Missing log. Name: %s Level: %s, message fragment: %s",
                        logRecord.getLoggerName(), logRecord.getLevel(), logRecord.getMessage());
                throw new AssertionError(message);
            }
        });
    }

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
