package com.epam.junit.runner.suite;

import com.epam.junit.rule.customrule.LogTest;
import com.epam.junit.rule.errorcollector.ErrorCollectorTest;
import com.epam.junit.rule.exception.ExceptionTesting;
import com.epam.junit.rule.externalresource.ExternalResourceTest;
import com.epam.junit.rule.rulechain.RuleChainTest;
import com.epam.junit.rule.tempfolder.TempFolderTest;
import com.epam.junit.rule.testmethodname.TestNameTest;
import com.epam.junit.rule.testwatcher.TestWatcherTest;
import com.epam.junit.rule.timeout.TimeoutRuleTest;
import com.epam.junit.rule.timeout.TimeoutTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({TimeoutTest.class, TimeoutRuleTest.class, TestWatcherTest.class, TestNameTest.class,
        TempFolderTest.class, RuleChainTest.class, ExternalResourceTest.class, ExceptionTesting.class,
        ErrorCollectorTest.class, LogTest.class})
public class RuleTests {
}
