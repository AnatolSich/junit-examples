package com.epam.junit.runner.customrunner.testnamerunner;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.List;
public class TestNameValidatorRunner extends BlockJUnit4ClassRunner {
    private static final String TEST_NAME_REGEX = "test[A-Z]\\w.+Should[A-Z]\\w.+When[A-Z]\\w.+";
    public TestNameValidatorRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected void validatePublicVoidNoArgMethods(Class<? extends Annotation> annotation, boolean isStatic,
            List<Throwable> errors) {
        List methods = this.getTestClass().getAnnotatedMethods(annotation);
        Iterator i$ = methods.iterator();

        while (i$.hasNext()) {
            FrameworkMethod eachTestMethod = (FrameworkMethod) i$.next();
            if (!eachTestMethod.getName().matches(TEST_NAME_REGEX)) {
                errors.add(new Exception("Method " + eachTestMethod.getName() + " should match naming convention("
                        + TEST_NAME_REGEX + ")"));
            }
            eachTestMethod.validatePublicVoidNoArg(isStatic, errors);
        }
    }
}
