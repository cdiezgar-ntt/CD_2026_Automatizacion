package com.nttdata.automation.reports;

public class Report {

    private Report() {
    }

    public static void info(String message) {
        TestExecutionContext.getReporter().info(message);
    }

    public static void pass(String message) {
        TestExecutionContext.getReporter().pass(message);
    }

    public static void fail(String message) {
        TestExecutionContext.getReporter().fail(message);
    }

    public static void warn(String message) {
        TestExecutionContext.getReporter().warn(message);
    }
}
