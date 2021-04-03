package com.epam.junit.rule.rulechain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
public class RuleChainTest {

    @Rule
    public TestRule testRule = RuleChain.outerRule(new LogRule("outer")).around(new LogRule("inner"))
            .around(new LogRule("inner2"));

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }
}
