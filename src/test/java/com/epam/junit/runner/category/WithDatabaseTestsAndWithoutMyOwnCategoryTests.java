package com.epam.junit.runner.category;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//Category can be Included and Excluded
@RunWith(org.junit.experimental.categories.Categories.class)
@Categories.IncludeCategory(MyCategories.DatabaseTest.class)
@Categories.ExcludeCategory(MyCategories.MyOwnCategory.class)
@Suite.SuiteClasses({TestA.class, TestB.class})
public class WithDatabaseTestsAndWithoutMyOwnCategoryTests {
}
