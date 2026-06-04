package com.nttdata.automation.reports;

public enum NoOpTestReporter implements TestReporter {

    INSTANCE;

    @Override
    public void info(String message) {
    }

    @Override
    public void pass(String message) {
    }

    @Override
    public void fail(String message) {
    }

    @Override
    public void warn(String message) {
    }
}
