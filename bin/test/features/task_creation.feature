@task_creation
Feature: Task Creation
  As a user of the Todo app
  I want to create new tasks
  So that I can manage my to-do items

  Background:
    Given I am on the main task list screen

  @smoke @positive
  Scenario: Successfully create a task with title only
    When I tap the add task button
    And I enter task title "Buy groceries"
    And I save the task
    Then I should see task "Buy groceries" in the list

  @smoke @positive
  Scenario: Create a task with title and description
    When I tap the add task button
    And I enter task title "Complete project report"
    And I enter task description "Write the Q4 summary"
    And I save the task
    Then I should see task "Complete project report" in the list

  @negative @validation
  Scenario: Attempt to save task with empty title
    When I tap the add task button
    And I save the task
    Then I should see an error message for empty title

  @negative
  Scenario: Cancel task creation
    When I tap the add task button
    And I enter task title "Task I will cancel"
    And I cancel task creation
    Then I should remain on the task list screen