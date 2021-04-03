package com.epam.junit.basic.custommatcher;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class PalindromeMatcher extends BaseMatcher<String> {

    private final boolean lookingForPositiveMatch;

    private PalindromeMatcher(boolean lookingForPositiveMatch) {
        this.lookingForPositiveMatch = lookingForPositiveMatch;
    }

    public static Matcher<String> isAPalindrome() {
        return new PalindromeMatcher(true);
    }

    public static Matcher<String> isNotAPalindrome() {
        return new PalindromeMatcher(false);
    }

    @Override
    public boolean matches(Object input) {
        boolean result = false;
        if (input != null) {
            String str = String.class.cast(input);
            StringBuilder builder = new StringBuilder(str);
            result = str.equals(builder.reverse().toString());
            if (!lookingForPositiveMatch) {
                result = !result;
            }
        }
        return result;
    }

    @Override
    public void describeTo(Description description) {
        String message = (lookingForPositiveMatch ? "" : "not ") + "to be a palidrome, but it " + (lookingForPositiveMatch ? "wasn't" : "was");
        description.appendText(message);
    }
}
