package com.nttdata.automation.reports;

public class TestExecutionContext {

    private static final ThreadLocal<TestReporter> reporterTL = new ThreadLocal<>();

    private TestExecutionContext() {
    }

    public static void setReporter(TestReporter reporter) {
        reporterTL.set(reporter);
    }

    public static TestReporter getReporter() {

        return reporterTL.get();
    }

    public static void clear() {
        reporterTL.remove();
    }
}
