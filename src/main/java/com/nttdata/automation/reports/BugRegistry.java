package com.nttdata.automation.reports;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BugRegistry {

    private static final List<BugEntry> bugs = Collections.synchronizedList(new ArrayList<>());

    public static void add(String feature, String scenario, String step, String evidenceBase64) {
        bugs.add(new BugEntry(feature, scenario, step, evidenceBase64));
    }

    public static List<BugEntry> getBugs() {
        return new ArrayList<>(bugs);
    }

    public static boolean hasBugs() {
        return !bugs.isEmpty();
    }

    public record BugEntry(
            String feature,
            String scenario,
            String step,
            String evidenceBase64
    ) {
    }
}