package com.todo.steps;

import com.todo.pages.AddTaskPage;
import com.todo.pages.MainPage;
import com.todo.pages.TaskDetailPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class TaskManagementSteps {

    private static final Logger log = LoggerFactory.getLogger(TaskManagementSteps.class);
    private final MainPage mainPage = new MainPage();
    private final AddTaskPage addTaskPage = new AddTaskPage();
    private final TaskDetailPage taskDetailPage = new TaskDetailPage();

    @When("I tap on task {string}")
    @Step("Tap on task: {0}")
    public void iTapOnTask(String title) {
        mainPage.tapTask(title);
    }

    @Then("I should see the task detail screen for {string}")
    @Step("Verify task detail screen for: {0}")
    public void iShouldSeeTaskDetailScreen(String title) {
        assertThat(taskDetailPage.getTaskTitle())
                .as("Task detail title should match")
                .isEqualToIgnoringCase(title);
    }

    @When("I tap the edit button")
    @Step("Tap edit button")
    public void iTapTheEditButton() {
        taskDetailPage.tapEdit();
    }

    @And("I update the task title to {string}")
    @Step("Update task title to: {0}")
    public void iUpdateTheTaskTitleTo(String title) {
        addTaskPage.enterTitle(title);
    }

    @Then("I should see task {string} is updated in the list")
    @Step("Verify updated task {0} is in list")
    public void iShouldSeeTaskIsUpdated(String title) {
        assertThat(mainPage.isTaskVisible(title))
                .as("Updated task '%s' should be visible", title)
                .isTrue();
    }

    @And("I mark the task as complete")
    @Step("Mark task as complete")
    public void iMarkTheTaskAsComplete() {
        taskDetailPage.tapCompleteCheckbox();
    }

    @Then("the task should be marked as completed")
    @Step("Verify task is completed")
    public void theTaskShouldBeMarkedAsCompleted() {
        assertThat(taskDetailPage.isTaskCompleted())
                .as("Task should be completed")
                .isTrue();
    }

    @When("I tap the delete button")
    @Step("Tap delete button")
    public void iTapTheDeleteButton() {
        taskDetailPage.tapDelete();
    }

    @And("I confirm the deletion")
    @Step("Confirm deletion")
    public void iConfirmTheDeletion() {
        taskDetailPage.confirmDelete();
    }

    @Then("the task {string} should not appear in the list")
    @Step("Verify task {0} is deleted")
    public void theTaskShouldNotAppearInTheList(String title) {
        assertThat(mainPage.isTaskVisible(title))
                .as("Deleted task '%s' should not be visible", title)
                .isFalse();
    }

    @And("I cancel the deletion")
    @Step("Cancel deletion")
    public void iCancelTheDeletion() {
        taskDetailPage.cancelDelete();
    }

    @Then("I should still see task {string} in the detail screen")
    @Step("Verify task {0} still visible in detail screen")
    public void iShouldStillSeeTaskInDetailScreen(String title) {
        assertThat(taskDetailPage.getTaskTitle())
                .as("Task should still be visible after cancel")
                .isEqualToIgnoringCase(title);
    }
}