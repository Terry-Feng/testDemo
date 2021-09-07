@API
Feature: User

  As a tester, I want to check if the user interface works well

  Scenario Outline: user register
    Given The resource "users" on "prod" environment is ready
    When I register a new user with following data
      | username   | password   |
      | <username> | <password> |
    Then Server response with following data
      | status   | message   |
      | <status> | <message> |
    Examples:
      | username | password    | status | message                                        |
      | random   | 1           | 400    | minimum field size of 6                        |
      | random   | 123456      | 400    | Password not long enough                       |
      | random   | 12345678    | 400    | Password must have lowercase characters        |
      | random   | 12345678a   | 400    | Password must have uppercase characters        |
      | random   | 12345678aA  | 400    | Password must have symbol characters           |
      | random   | 12345678aA  | 400    | Password must have symbol characters           |
      | test     | 12345678aA! | 400    | User already exists                            |
      | te st    | 12345678aA! | 400    | Member must satisfy regular expression pattern |
      | random   | 12345678aA! | 201    |                                                |

  Scenario Outline: user login
    Given The resource "oauth/token" on "prod" environment is ready
    When I login with user "<username>" and password "<password>"
    Then Server response status "<status>" and message "<message>"
    Examples:
      | username        | password | status | message             |
      | RickieReichel   | 123      | 401    | Invalid credentials |
      | RickieReichel   | Test!123 | 200    | access_token        |
      | username[$ne]=1 | Test!123 | 200    | access_token        |
      | admin[$ne]=1    | 12345678 | 401    | Invalid credentials |