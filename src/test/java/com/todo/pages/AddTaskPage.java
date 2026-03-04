package com.todo.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class AddTaskPage extends BasePage {

    @AndroidFindBy(id = "com.example.todo:id/task_title_input")
    private WebElement titleInput;

    @AndroidFindBy(id = "com.example.todo:id/task_description_input")
    private WebElement descriptionInput;

    @AndroidFindBy(id = "com.example.todo:id/priority_spinner")
    private WebElement prioritySpinner;

    @AndroidFindBy(id = "com.example.todo:id/save_task_button")
    private WebElement saveButton;

    @AndroidFindBy(id = "com.example.todo:id/cancel_button")
    private WebElement cancelButton;

    @AndroidFindBy(id = "com.example.todo:id/title_error")
    private WebElement titleError;

    public void enterTitle(String title) {
        log.info("Entering task title: {}", title);
        type(titleInput, title);
    }

    public void enterDescription(String description) {
        log.info("Entering task description: {}", description);
        type(descriptionInput, description);
    }

    public void selectPriority(String priority) {
        log.info("Selecting priority: {}", priority);
        click(prioritySpinner);
    }

    public void tapSave() {
        log.info("Tapping Save button");
        click(saveButton);
    }

    public void tapCancel() {
        log.info("Tapping Cancel button");
        click(cancelButton);
    }

    public boolean isTitleErrorDisplayed() {
        return isDisplayed(titleError);
    }

    public String getTitleErrorText() {
        return getText(titleError);
    }
}