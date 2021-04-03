package com.epam.junit.rule.rulechain;

import org.junit.rules.Verifier;
public class LogRule extends Verifier {

    private String message;

    public LogRule(String message) {
        this.message = message;
    }

    @Override
    protected void verify() throws Throwable {
        System.out.println(message);
    }
}
