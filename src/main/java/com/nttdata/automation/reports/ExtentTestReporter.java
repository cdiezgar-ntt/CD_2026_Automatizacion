package com.nttdata.automation.reports;


import com.nttdata.automation.hooks.ExtentReportHook;

public class ExtentTestReporter implements TestReporter {
    @Override
    public void info(String message) {
        ExtentReportHook.logInfo(message);
    }

    @Override
    public void pass(String message) {
        ExtentReportHook.logPass(message);
    }

    @Override
    public void fail(String message) {
        ExtentReportHook.logFail(message);
    }

    @Override
    public void warn(String message) {
        ExtentReportHook.logWarn(message);
    }

}
