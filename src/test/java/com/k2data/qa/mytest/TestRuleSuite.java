package com.k2data.qa.mytest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestRule1.class,
	TestRule2.class
})
public class TestRuleSuite {

}
