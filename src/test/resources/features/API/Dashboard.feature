@API
Feature: Dashboard

  As a tester, I want to make sure the dashboard works well

  Scenario: most popular maker
    Given The resource "dashboard" on "prod" environment is ready
    When I check the most popular maker
    Then The response contains most popular maker information

  Scenario: most popular model
    Given The resource "dashboard" on "prod" environment is ready
    When I check the most popular model
    Then The response contains most popular model information