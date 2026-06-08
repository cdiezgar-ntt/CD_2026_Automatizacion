package com.nttdata.automation.jira_integration;

public final class XrayTestContext {

    private static final ThreadLocal<String> CURRENT_TEST_KEY = new ThreadLocal<>();
    private static final ThreadLocal<XrayStatus> CURRENT_SCENARIO_STATUS = new ThreadLocal<>();

    private XrayTestContext() {
    }

    public static void setCurrentTestKey(String testKey) {
        CURRENT_TEST_KEY.set(testKey);
        CURRENT_SCENARIO_STATUS.remove();
    }

    public static String getCurrentTestKey() {
        return CURRENT_TEST_KEY.get();
    }

    public static void markCurrentScenarioFail() {
        CURRENT_SCENARIO_STATUS.set(XrayStatus.FAIL);
    }

    public static void markCurrentScenarioBlocked() {
        CURRENT_SCENARIO_STATUS.set(XrayStatus.BLOCKED);
    }

    public static XrayStatus getCurrentScenarioStatus() {
        return CURRENT_SCENARIO_STATUS.get();
    }

    public static void clear() {
        CURRENT_TEST_KEY.remove();
        CURRENT_SCENARIO_STATUS.remove();
    }
}