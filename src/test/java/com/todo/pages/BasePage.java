package com.todo.pages;

import com.todo.utils.AppiumConfig;
import com.todo.utils.WaitUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public abstract class BasePage {

    protected AndroidDriver driver;
    protected static final Logger log = LoggerFactory.getLogger(BasePage.class);

    public BasePage() {
        this.driver = AppiumConfig.getDriver();
        PageFactory.initElements(
            new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this
        );
    }

    protected void click(WebElement element) {
        log.debug("Clicking element: {}", element);
        WaitUtils.waitForClickable(element).click();
    }

    protected void type(WebElement element, String text) {
        log.debug("Typing '{}' into element", text);
        WaitUtils.waitForVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(WebElement element) {
        return WaitUtils.waitForVisible(element).getText();
    }

    protected boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}