package com.nttdata.automation.reports;

public interface TestReporter {

    void info(String message);

    void pass(String message);

    void fail(String message);

    void warn(String message);
}
