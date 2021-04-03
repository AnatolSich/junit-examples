package com.epam.junit.runner.customrunner.paramsfromannotationrunner;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//Created special annotation to use in custom runner
@Retention(RetentionPolicy.RUNTIME)
public @interface OwnParamsAnnotation {
    int[] value() default {};
}
