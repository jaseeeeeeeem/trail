Feature: To execute the given testcases

Scenario: To check if jwmarriot is present
Given driver is initialised
And user enters "https://www.marriott.com/default.mi"
When user clicks on our brands
Then jwmarriot should be present

Scenario: To find hotels
Given driver is initialised
And user enters "https://www.marriott.com/default.mi"
When user enters "Barcelona" and search
Then the first result address should contain "Barcelona"

Scenario: To check if the Text is displayed
Given driver is initialised
And user enters "https://www.marriott.com/default.mi"
When user clicks on member benefits
Then the page should contain the text 


