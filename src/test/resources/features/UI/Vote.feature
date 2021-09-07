@UI
Feature: Vote

  As a tester, I want to check if the vote function is working fine

  Scenario: User vote
    Given The home page is ready
    When I login with new user "random" and "random"
    Then login success
    When I vote for the first car
    Then The vote result and comment is correct