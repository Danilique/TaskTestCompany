package com.todo.pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends BasePage {

    @AndroidFindBy(accessibility = "Add task")
    private WebElement addTaskFab;

    @AndroidFindBy(id = "com.example.todo:id/task_list")
    private WebElement taskList;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.example.todo:id/task_title']")
    private List<WebElement> taskTitles;

    @AndroidFindBy(id = "com.example.todo:id/empty_view")
    private WebElement emptyView;

    @AndroidFindBy(id = "com.example.todo:id/toolbar_title")
    private WebElement toolbarTitle;

    public void tapAddTask() {
        log.info("Tapping Add Task button");
        click(addTaskFab);
    }

    public boolean isTaskListDisplayed() {
        return isDisplayed(taskList);
    }

    public boolean isEmptyViewDisplayed() {
        return isDisplayed(emptyView);
    }

    public int getTaskCount() {
        return taskTitles.size();
    }

    public boolean isTaskVisible(String title) {
        return taskTitles.stream()
                .anyMatch(t -> t.getText().equalsIgnoreCase(title));
    }

    public void tapTask(String title) {
        log.info("Tapping task: {}", title);
        taskTitles.stream()
                .filter(t -> t.getText().equalsIgnoreCase(title))
                .findFirst()
                .ifPresent(this::click);
    }

    public String getToolbarTitle() {
        return getText(toolbarTitle);
    }
}