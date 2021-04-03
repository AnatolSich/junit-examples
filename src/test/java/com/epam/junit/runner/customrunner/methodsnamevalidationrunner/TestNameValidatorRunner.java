package com.epam.junit.runner.customrunner.methodsnamevalidationrunner;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.List;

//Custom runner for checking test methods names
public class TestNameValidatorRunner extends BlockJUnit4ClassRunner {
    private static final String TEST_NAME_REGEX = "test[A-Z]\\w.+Should[A-Z]\\w.+When[A-Z]\\w.+";

    public TestNameValidatorRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @Override
    protected void validatePublicVoidNoArgMethods(Class<? extends Annotation> annotation,
                                                  boolean isStatic,
                                                  List<Throwable> errors) {
        List methods = this.getTestClass().getAnnotatedMethods(annotation);
        Iterator iterator = methods.iterator();

        while (iterator.hasNext()) {
            FrameworkMethod eachTestMethod = (FrameworkMethod) iterator.next();
            if (!eachTestMethod.getName().matches(TEST_NAME_REGEX)) {
                errors.add(new Exception("Method " + eachTestMethod.getName() + " should match naming convention("
                        + TEST_NAME_REGEX + ")"));
            }
            eachTestMethod.validatePublicVoidNoArg(isStatic, errors);
        }
    }
}
