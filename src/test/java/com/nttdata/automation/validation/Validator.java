package com.nttdata.automation.validation;

import com.nttdata.automation.hooks.ExtentReportHook;
import org.junit.Assert;

public class Validator {

    public static void validarVerdadero(Boolean exp, String msg) {
        try {
            Assert.assertTrue(exp);
            ExtentReportHook.getTest().pass(msg);
        } catch (AssertionError error) {
            ExtentReportHook.getTest().fail(msg);
        }
    }

    public static void validarFalso(Boolean exp, String msg) {
        try {
            Assert.assertFalse(exp);
            ExtentReportHook.getTest().pass(msg);
        } catch (AssertionError error) {
            ExtentReportHook.getTest().fail(msg);
        }
    }
}
