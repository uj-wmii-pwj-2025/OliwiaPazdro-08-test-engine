package uj.wmii.pwj.anns;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyTestEngine {

    private final String className;

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Please specify test class name");
            System.exit(-1);
        }

        Banner banner = new Banner();
        banner.printBanner("Fancy Test Engine");

        String className = args[0].trim();
        System.out.printf("\n\nTesting class: %s\n\n", className);

        MyTestEngine engine = new MyTestEngine(className);
        engine.runTests();
    }

    public MyTestEngine(String className) {

        this.className = className;
    }

    public void runTests() {

        final Object unit = getObject(className);
        List<Method> testMethods = getTestMethods(unit);

        long passCount = 0, failCount = 0, errorCount = 0;

        for (Method m : testMethods) {
            List<TestResult> results = launchSingleMethod(m, unit);

            passCount += results.stream().filter(r -> r == TestResult.PASS).count();
            failCount += results.stream().filter(r -> r == TestResult.FAIL).count();
            errorCount += results.stream().filter(r -> r == TestResult.ERROR).count();
        }

        System.out.println("\n============ summary ============");
        System.out.printf("Total tests: %d - PASS: %d - FAIL: %d - ERROR: %d%n",
                            testMethods.size(), passCount, failCount, errorCount);
    }

    private List<TestResult> launchSingleMethod(Method m, Object unit) {

        List<TestResult> results = new ArrayList<>();
        MyTest ann = m.getAnnotation(MyTest.class);
        String[] params = ann.params();
        String expected = ann.expectedResult();

        System.out.printf("%n--- running test for method: %s --- %n", m.getName());

        if (params.length == 0)
            results.add(runAndDisplayResult(m, unit, null, expected));
        else
            for (String p : params)
                results.add(runAndDisplayResult(m, unit, p, expected));

        return results;
    }

    private TestResult runAndDisplayResult(Method m, Object unit, String param, String expected) {

        try {
            Object result = (param == null) ? m.invoke(unit) : m.invoke(unit, param);
            String actual = String.valueOf(result);

            if (!expected.isEmpty()) {
                boolean ifPassed = actual.equals(expected);
                System.out.printf("Method: %s(%s) - actual: %s - expected: %s - status: %s%n%n",
                                    m.getName(), param, actual, expected, ifPassed ? "PASS" : "FAIL");
                return ifPassed ? TestResult.PASS : TestResult.FAIL;
            } else {
                System.out.printf("Method: %s(%s) - actual: %s - no expected result - status: PASS%n%n",
                                    m.getName(), param, actual);
                return TestResult.PASS;
            }

        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            System.out.printf("Method: %s(%s) - unhandled exception: %s - ERROR%n%n",
                                m.getName(), param, cause.getClass());
            return TestResult.ERROR;
        } catch (Exception e) {
            System.out.printf("Method: %s(%s) - reflection error - ERROR%n%n", m.getName(), param);
            return TestResult.ERROR;
        }
    }

    private static List<Method> getTestMethods(Object unit) {
        Method[] methods = unit.getClass().getDeclaredMethods();
        return Arrays.stream(methods).filter(
                m -> m.getAnnotation(MyTest.class) != null).collect(Collectors.toList());
    }

    private static Object getObject(String className) {
        try {
            Class<?> unitClass = Class.forName(className);
            return unitClass.getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
            return new Object();
        }
    }
}
