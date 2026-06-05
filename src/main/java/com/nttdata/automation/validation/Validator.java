package com.nttdata.automation.validation;
import com.nttdata.automation.jira_integration.XrayResultCollector;
import com.nttdata.automation.jira_integration.XrayTestContext;
import com.nttdata.automation.reports.*;
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
                String testKey = XrayTestContext.getCurrentTestKey();
                XrayResultCollector.markBlocked(testKey);
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
                String testKey = XrayTestContext.getCurrentTestKey();
                XrayResultCollector.markBlocked(testKey);
                throw error;
            }
        }
    }

    private static void logPass(String msg, boolean conCaptura) {
        TestReporter reporter = TestExecutionContext.getReporter();

        if (conCaptura) {
            String imgBase64 = ScreenRecorder.takeScreenShotBase64();

            if (imgBase64 != null && !imgBase64.isEmpty()) {
                String html = EvidenceHtmlBuilder.buildEvidenceButtons(
                        imgBase64,
                        "Evidencia OK"
                );

                reporter.pass(msg + html);
                return;
            }
        }

        reporter.pass(msg);
    }

    private static void logFail(String msg, boolean conCaptura) {

        String currentTestKey = XrayTestContext.getCurrentTestKey();

        if (currentTestKey != null && !currentTestKey.isBlank()) {
            XrayResultCollector.markFail(currentTestKey);
        }

        TestReporter reporter = TestExecutionContext.getReporter();

        if (conCaptura) {
            String imgBase64 = ScreenRecorder.takeScreenShotBase64();

            if (imgBase64 != null && !imgBase64.isEmpty()) {
                String html = EvidenceHtmlBuilder.buildEvidenceButtons(
                        imgBase64,
                        "Evidencia ERROR"
                );

                reporter.fail(msg + html);
                return;
            }
        }

        reporter.fail(msg);
    }

}