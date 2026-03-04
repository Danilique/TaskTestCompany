package com.todo.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class TaskDetailPage extends BasePage {

    @AndroidFindBy(id = "com.example.todo:id/task_title")
    private WebElement taskTitle;

    @AndroidFindBy(id = "com.example.todo:id/task_description")
    private WebElement taskDescription;

    @AndroidFindBy(id = "com.example.todo:id/task_status_checkbox")
    private WebElement completedCheckbox;

    @AndroidFindBy(id = "com.example.todo:id/edit_task_button")
    private WebElement editButton;

    @AndroidFindBy(id = "com.example.todo:id/delete_task_button")
    private WebElement deleteButton;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement confirmDeleteButton;

    @AndroidFindBy(id = "android:id/button2")
    private WebElement cancelDeleteButton;

    public String getTaskTitle() {
        return getText(taskTitle);
    }

    public String getTaskDescription() {
        return getText(taskDescription);
    }

    public void tapEdit() {
        log.info("Tapping Edit button");
        click(editButton);
    }

    public void tapDelete() {
        log.info("Tapping Delete button");
        click(deleteButton);
    }

    public void confirmDelete() {
        log.info("Confirming deletion");
        click(confirmDeleteButton);
    }

    public void cancelDelete() {
        log.info("Cancelling deletion");
        click(cancelDeleteButton);
    }

    public void tapCompleteCheckbox() {
        log.info("Tapping complete checkbox");
        click(completedCheckbox);
    }

    public boolean isTaskCompleted() {
        return completedCheckbox.isSelected();
    }
}