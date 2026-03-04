package com.todo.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumConfig {

    private static final Logger log = LoggerFactory.getLogger(AppiumConfig.class);
    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        return driver;
    }

    public static void initDriver() throws MalformedURLException {
        log.info("Initializing Appium driver...");

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(ConfigReader.get("device.name"));
        options.setPlatformVersion(ConfigReader.get("platform.version"));
        options.setApp(ConfigReader.get("app.path"));
        options.setAppPackage(ConfigReader.get("app.package"));
        options.setAppActivity(ConfigReader.get("app.activity"));
        options.setAutomationName("UiAutomator2");
        options.setNoReset(false);
        options.setNewCommandTimeout(Duration.ofSeconds(60));

        String appiumUrl = ConfigReader.get("appium.url");
        driver = new AndroidDriver(new URL(appiumUrl), options);
        driver.manage().timeouts()
            .implicitlyWait(Duration.ofSeconds(ConfigReader.getInt("implicit.wait")));

        log.info("Driver initialized successfully on {}", appiumUrl);
    }

    public static void quitDriver() {
        if (driver != null) {
            log.info("Quitting Appium driver...");
            driver.quit();
            driver = null;
        }
    }
}