Feature: Create Quote

  Scenario: Fill the forms and create Quote
    Given I enter the Enter vehicle data
    When Fill out the form, Enter Vehicle Data tab and if you select the next button
    Then the system will go to the Enter Insurant Data
    Given that I have the Enter Insurant Data
    When Fill out the form, Enter Insurant Data tab and if you select the next button
    Then the system will go to the Enter product data
    Given that I have the Enter product data
    When Fill out the form, Enter product data tab and if you select the next button
    Then the system will go to the Select Price Option
    Given that I have the Select Price Option
    When Fill out the form, Select Price Option tab and if you select the next button
    Then the system will go to the  Send Quote
    Given that I have the Send Quote
    When Fill out the form, Send Quote tab and if you select the next button
    Then the system should display Sending e-mail success!