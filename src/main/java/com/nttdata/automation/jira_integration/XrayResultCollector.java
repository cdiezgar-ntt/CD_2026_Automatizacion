package com.nttdata.automation.jira_integration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class XrayResultCollector {

    private static final Map<String, XrayStatus> STATUSES = new ConcurrentHashMap<>();

    private XrayResultCollector() {
    }

    public static void markFail(String testKey) {
        setStatus(testKey, XrayStatus.FAIL);
    }

    public static void markBlocked(String testKey) {
        setStatus(testKey, XrayStatus.BLOCKED);
    }

    public static String getStatus(String testKey, String defaultStatus) {
        if (testKey == null || testKey.isBlank()) {
            return defaultStatus;
        }

        XrayStatus status = STATUSES.get(testKey.trim());
        return status == null ? defaultStatus : status.name();
    }

    private static void setStatus(String testKey, XrayStatus incomingStatus) {
        if (testKey == null || testKey.isBlank()) {
            return;
        }

        STATUSES.merge(
                testKey.trim(),
                incomingStatus,
                XrayResultCollector::resolvePriority
        );

        System.out.println("[XRAY] Estado acumulado para "
                + testKey
                + " = "
                + STATUSES.get(testKey.trim()));
    }

    private static XrayStatus resolvePriority(XrayStatus currentStatus, XrayStatus incomingStatus) {
        if (currentStatus == XrayStatus.FAIL || incomingStatus == XrayStatus.FAIL) {
            return XrayStatus.FAIL;
        }

        if (currentStatus == XrayStatus.BLOCKED || incomingStatus == XrayStatus.BLOCKED) {
            return XrayStatus.BLOCKED;
        }

        return XrayStatus.PASS;
    }
}