package com.nttdata.automation.validation;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.nttdata.automation.hooks.ExtentReportHook;
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
            //Comentar si se quiere que una validación detenga el test
            if (bloqueante) throw error;
        }
    }

    public static void validarFalso(Boolean exp, String msg) {
        validarFalso(exp, msg, false);
    }

    public static void validarFalso(Boolean exp, String msg, Boolean bloqueante) {
        validarFalso(exp, msg, bloqueante, bloqueante);
    }

    public static void validarFalso(Boolean exp, String msg, boolean conCaptura , boolean bloqueante) {
        try {
            Assert.assertFalse(exp);
            logPass(msg, conCaptura);
        } catch (AssertionError error) {
            logFail(msg, conCaptura);
            //Comentar si se quiere que una validación detenga el test
            if (bloqueante) throw error;
        }
    }

    private static void logPass(String msg, boolean conCaptura) {
        if (conCaptura) {
            String img = ScreenRecorder.takeScreenShot(
                    ExtentReportHook.getCasePath(),
                    "Evidencia_ok"
            );

            if (!img.isEmpty()) {
                ExtentReportHook.getTest().pass(
                        msg,
                        MediaEntityBuilder.createScreenCaptureFromPath(img).build()
                );
                return;
            }
        }

        ExtentReportHook.getTest().pass(msg);
    }

    private static void logFail(String msg, boolean conCaptura) {
        if (conCaptura) {
            String img = ScreenRecorder.takeScreenShot(
                    ExtentReportHook.getCasePath(),
                    "Evidencia_error"
            );

            if (!img.isEmpty()) {
                ExtentReportHook.getTest().fail(
                        msg,
                        MediaEntityBuilder.createScreenCaptureFromPath(img).build()
                );
                return;
            }
        }

        ExtentReportHook.getTest().fail(msg);
    }
}
