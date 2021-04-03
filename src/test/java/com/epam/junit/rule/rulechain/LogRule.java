package com.epam.junit.rule.rulechain;

import org.junit.rules.Verifier;

/*Verifier is a base class for Rules like ErrorCollector, which can turn
 passing test methods into failing tests if a verification check is failed*/
//we overrode verify() for only printing messages
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
