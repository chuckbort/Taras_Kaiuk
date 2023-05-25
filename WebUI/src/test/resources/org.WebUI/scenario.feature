Feature: WebUI Selenium Home task

  Scenario: Create and delete job Title
    Given I open page "https://opensource-demo.orangehrmlive.com/"
    When I fill login form
    Then I successful login


    Given I go to Add Job Title page (Admin -> Job - Job Titles page -> Click on the Add button)
    When I fill job title form
        | Job title    | Job description                | Job notes |
        | Intern       | Automation Testing Intern      | Notes     |
      And save new job
    Then I successful add new Job Title


    Given There is my job title in Job list
    When I select my title and delete it
    Then I successful delete my Job Title