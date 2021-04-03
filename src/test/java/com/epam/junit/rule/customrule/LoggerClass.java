package com.epam.junit.rule.customrule;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerClass {
    private Logger logger;

    public LoggerClass(String loggerName) {
        this.logger = Logger.getLogger(loggerName);
    }

    public void logInfo() {
        logger.log(Level.INFO, "this is a normal log");
    }

    public void logError() {
        logger.log(Level.SEVERE, "something went wrong");
    }
}
