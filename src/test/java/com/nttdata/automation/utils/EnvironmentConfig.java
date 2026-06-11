package com.nttdata.automation.utils;

public final class EnvironmentConfig {

    private final PropertiesReader propertiesReader;

    public EnvironmentConfig(PropertiesReader propertiesReader) {
        this.propertiesReader = propertiesReader;
    }

    // Por defecto se ejecuta en pre
    public String currentEnv() {
        return System.getProperty("env", "se").toLowerCase();
    }

    public String environmentFile() {
        return "/src/test/resources/config/environment-" + currentEnv() + ".properties";
    }

    public String brunoEnvironment() {
        return propertiesReader.get(environmentFile(), "bruno_environment");
    }

    public String environmentProperty(String key) {
        String file = "config/environment-" + currentEnv() + ".properties";
        return propertiesReader.get(file, key);
    }
}