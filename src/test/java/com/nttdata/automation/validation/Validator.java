package com.nttdata.automation.validation;

import com.aventstack.extentreports.ExtentTest;
import com.nttdata.automation.hooks.ExtentReportHook;
import com.nttdata.automation.reports.EvidenceHtmlBuilder;
import com.nttdata.automation.reports.ScreenRecorder;
import org.junit.Assert;

public class Validator {

    public static void validarVerdadero(Boolean exp, String msg) {
        validarVerdadero(exp, msg, false, false);
    }

    public static void validarVerdadero(Boolean exp, String msg, Boolean conCaptura) {
        validarVerdadero(exp, msg, conCaptura, false);
    }

    public static void validarVerdadero(Boolean exp, String msg, boolean conCaptura, boolean bloqueante) {
        try {
            Assert.assertTrue(exp);
            logPass(msg, conCaptura);
        } catch (AssertionError error) {
            logFail(msg, conCaptura);

            if (bloqueante) {
                throw error;
            }
        }
    }

    public static void validarFalso(Boolean exp, String msg) {
        validarFalso(exp, msg, false);
    }

    public static void validarFalso(Boolean exp, String msg, Boolean bloqueante) {
        validarFalso(exp, msg, bloqueante, bloqueante);
    }

    public static void validarFalso(Boolean exp, String msg, boolean conCaptura, boolean bloqueante) {
        try {
            Assert.assertFalse(exp);
            logPass(msg, conCaptura);
        } catch (AssertionError error) {
            logFail(msg, conCaptura);

            if (bloqueante) {
                throw error;
            }
        }
    }

    private static void logPass(String msg, boolean conCaptura) {
        if (conCaptura) {
            String imgBase64 = ScreenRecorder.takeScreenShotBase64();

            if (imgBase64 != null && !imgBase64.isEmpty()) {
                String html = EvidenceHtmlBuilder.buildEvidenceButtons(
                        imgBase64,
                        "Evidencia OK"
                );

                ExtentReportHook.getTest().pass(msg + html);
                return;
            }
        }

        ExtentReportHook.getTest().pass(msg);
    }
    private static void logFail(String msg, boolean conCaptura) {
        if (conCaptura) {
            String imgBase64 = ScreenRecorder.takeScreenShotBase64();

            if (imgBase64 != null && !imgBase64.isEmpty()) {
                String html = EvidenceHtmlBuilder.buildEvidenceButtons(
                        imgBase64,
                        "Evidencia ERROR"
                );

                ExtentReportHook.getTest().fail(msg + html);
                return;
            }
        }

        ExtentReportHook.getTest().fail(msg);
    }
    private static void pass(String msg) {
        ExtentTest globalTest = ExtentReportHook.getTest();
        ExtentTest featureTest = ExtentReportHook.getFeatureTest();

        if (globalTest != null) {
            globalTest.pass(msg);
        }

        if (featureTest != null) {
            featureTest.pass(msg);
        }
    }

    private static void fail(String msg) {
        ExtentTest globalTest = ExtentReportHook.getTest();
        ExtentTest featureTest = ExtentReportHook.getFeatureTest();

        if (globalTest != null) {
            globalTest.fail(msg);
            globalTest.assignCategory("BUGS");
        }

        if (featureTest != null) {
            featureTest.fail(msg);
            featureTest.assignCategory("BUGS");
        }
    }
}