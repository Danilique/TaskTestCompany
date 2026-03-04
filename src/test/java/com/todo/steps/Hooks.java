package com.todo.steps;

import com.todo.utils.AppiumConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;

public class Hooks {

    private static final Logger log = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void setUp() throws MalformedURLException {
        log.info("Setting up Appium driver...");
        AppiumConfig.initDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        log.info("Tearing down scenario: {}", scenario.getName());
        if (scenario.isFailed() && AppiumConfig.getDriver() != null) {
            log.warn("Scenario failed - capturing screenshot");
            byte[] screenshot = ((TakesScreenshot) AppiumConfig.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
            Allure.addAttachment(
                "Failure Screenshot",
                new ByteArrayInputStream(screenshot)
            );
        }
        AppiumConfig.quitDriver();
    }
}