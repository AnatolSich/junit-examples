package com.epam.junit.runner.category;

import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(org.junit.experimental.categories.Categories.class)
@IncludeCategory(MyCategories.DatabaseTest.class)
@SuiteClasses({TestA.class, TestB.class})
public class DatabaseTests {
}
