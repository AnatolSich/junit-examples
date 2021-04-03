package com.epam.junit.runner.customrunner.paramsfromannotationrunner;
import org.junit.Ignore;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//Custom runner to get parameters from special annotation
public class UseOwnParamsRunner extends BlockJUnit4ClassRunner {

    public UseOwnParamsRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @Override
    protected Statement methodInvoker(FrameworkMethod method, Object test) {
        return this.methodInvoker(method, test, new Object[0]);
    }

    protected Statement methodInvoker(FrameworkMethod method, Object test, Object[] params) {
        Annotation[] annotations = method.getAnnotations();
        if (isParamAnnotated(annotations)) {
            return new ParamInvoker(method, test);
        } else {
            return super.methodInvoker(method, test);
        }
    }

    private boolean isParamAnnotated(Annotation[] annotations) {
        return Arrays.stream(annotations).anyMatch(annotation -> annotation instanceof OwnParamsAnnotation);
    }

    @Override
    protected void validatePublicVoidNoArgMethods(Class<? extends Annotation> annotation, boolean isStatic,
            List<Throwable> errors) {
        List<FrameworkMethod> methods = this.getTestClass().getAnnotatedMethods(annotation);
        Iterator iterator = methods.iterator();
        while (iterator.hasNext()) {
            FrameworkMethod eachTestMethod = (FrameworkMethod) iterator.next();
            if (isParamAnnotated(eachTestMethod.getAnnotations())) {
                eachTestMethod.validatePublicVoid(isStatic, errors);
            } else {
                eachTestMethod.validatePublicVoidNoArg(isStatic, errors);
            }
        }
    }

    @Override
    protected void runChild(FrameworkMethod method, RunNotifier notifier) {
        OwnParamsAnnotation annotation = method.getAnnotation(OwnParamsAnnotation.class);
        Description description = this.describeChild(method);
        if (annotation == null) {
            super.runChild(method, notifier);
        } else if (method.getAnnotation(Ignore.class) != null) {
            notifier.fireTestIgnored(description);
        } else {
            int[] value = annotation.value();
            for (int i = 0; i < value.length; i++) {
                this.runLeaf(this.methodBlock(method, new Object[]{ value[i] }), description, notifier);
            }
        }
    }

    protected Statement methodBlock(FrameworkMethod method, Object[] params) {
        Statement statement = super.methodBlock(method);
        if (statement instanceof ParamInvoker) {
            ((ParamInvoker) statement).setParams(params);
        }
        return statement;
    }

    class ParamInvoker extends Statement {

        private final FrameworkMethod fTestMethod;
        private Object fTarget;
        private Object[] params;

        public void setParams(Object[] params) {
            this.params = params;
        }

        public ParamInvoker(FrameworkMethod testMethod, Object target) {
            this.fTestMethod = testMethod;
            this.fTarget = target;
        }

        public void evaluate() throws Throwable {
            this.fTestMethod.invokeExplosively(this.fTarget, params);
        }
    }

}
