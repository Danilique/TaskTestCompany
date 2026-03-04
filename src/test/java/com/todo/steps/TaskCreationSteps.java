package com.todo.steps;

import com.todo.pages.AddTaskPage;
import com.todo.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class TaskCreationSteps {

    private static final Logger log = LoggerFactory.getLogger(TaskCreationSteps.class);
    private final MainPage mainPage = new MainPage();
    private final AddTaskPage addTaskPage = new AddTaskPage();

    @Given("I am on the main task list screen")
    @Step("Open main task list screen")
    public void iAmOnTheMainTaskListScreen() {
        log.info("Verifying main screen is displayed");
        assertThat(mainPage.getToolbarTitle()).isNotEmpty();
    }

    @When("I tap the add task button")
    @Step("Tap add task button")
    public void iTapTheAddTaskButton() {
        mainPage.tapAddTask();
    }

    @And("I enter task title {string}")
    @Step("Enter task title: {0}")
    public void iEnterTaskTitle(String title) {
        addTaskPage.enterTitle(title);
    }

    @And("I enter task description {string}")
    @Step("Enter task description: {0}")
    public void iEnterTaskDescription(String description) {
        addTaskPage.enterDescription(description);
    }

    @And("I save the task")
    @Step("Save the task")
    public void iSaveTheTask() {
        addTaskPage.tapSave();
    }

    @Then("I should see task {string} in the list")
    @Step("Verify task {0} is visible in list")
    public void iShouldSeeTaskInTheList(String title) {
        assertThat(mainPage.isTaskVisible(title))
                .as("Task '%s' should be visible", title)
                .isTrue();
    }

    @Then("I should see an error message for empty title")
    @Step("Verify empty title error is shown")
    public void iShouldSeeAnErrorMessageForEmptyTitle() {
        assertThat(addTaskPage.isTitleErrorDisplayed())
                .as("Title error should be displayed")
                .isTrue();
    }

    @And("I cancel task creation")
    @Step("Cancel task creation")
    public void iCancelTaskCreation() {
        addTaskPage.tapCancel();
    }

    @Then("I should remain on the task list screen")
    @Step("Verify user is on task list screen")
    public void iShouldRemainOnTheTaskListScreen() {
        assertThat(mainPage.isTaskListDisplayed() || mainPage.isEmptyViewDisplayed())
                .as("Should be on task list screen")
                .isTrue();
    }
}