package com.epam.junit.rule.rulechain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;

public class RuleChainTest {

    //TestRule is an base class for rules.
    /*TestRule can do everything that could be done previously with
     * methods annotated with Before, After, BeforeClass, or AfterClass, but they are more powerful, and more easily
     * shared between projects and classes.*/

    //RuleChain rule - allows ordering of TestRules.
    //goes from the end to the start
    //inner2->inner->outer
    @Rule
    public TestRule testRule = RuleChain
            .outerRule(new LogRule("outer"))
            .around(new LogRule("inner"))
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
