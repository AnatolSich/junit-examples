package com.epam.junit.runner.customrunner.paramrunner;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
    int[] value() default {};
}
