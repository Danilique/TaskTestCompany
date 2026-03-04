package com.todo.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static WebDriverWait getWait() {
        int timeout = ConfigReader.getInt("explicit.wait");
        return new WebDriverWait(
            AppiumConfig.getDriver(),
            Duration.ofSeconds(timeout)
        );
    }

    public static WebElement waitForVisible(WebElement element) {
        return getWait().until(
            ExpectedConditions.visibilityOf(element)
        );
    }

    public static WebElement waitForClickable(WebElement element) {
        return getWait().until(
            ExpectedConditions.elementToBeClickable(element)
        );
    }

    public static void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}