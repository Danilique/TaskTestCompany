@task_management
Feature: Task Management
  As a user of the Todo app
  I want to manage my existing tasks
  So that I can track and update my to-do items

  Background:
    Given I am on the main task list screen
    And I tap the add task button
    And I enter task title "Sample Task"
    And I save the task

  @smoke @positive
  Scenario: View task details
    When I tap on task "Sample Task"
    Then I should see the task detail screen for "Sample Task"

  @smoke @positive
  Scenario: Edit an existing task
    When I tap on task "Sample Task"
    And I tap the edit button
    And I update the task title to "Updated Task"
    And I save the task
    Then I should see task "Updated Task" in the list

  @smoke @positive
  Scenario: Mark task as complete
    When I tap on task "Sample Task"
    And I mark the task as complete
    Then the task should be marked as completed

  @smoke @positive
  Scenario: Delete a task
    When I tap on task "Sample Task"
    And I tap the delete button
    And I confirm the deletion
    Then the task "Sample Task" should not appear in the list

  @negative
  Scenario: Cancel task deletion
    When I tap on task "Sample Task"
    And I tap the delete button
    And I cancel the deletion
    Then I should still see task "Sample Task" in the detail screen