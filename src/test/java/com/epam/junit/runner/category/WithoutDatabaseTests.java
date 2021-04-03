package com.epam.junit.runner.category;

import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(org.junit.experimental.categories.Categories.class)
@ExcludeCategory(MyCategories.DatabaseTest.class)
@Suite.SuiteClasses({TestA.class, TestB.class})
public class WithoutDatabaseTests {
}
