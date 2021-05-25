Feature: Games

  Scenario: Should get two cards from the top of a shuffled deck
    When I play from the top
    Then I get two cards from the top from a shuffled deck
    And game cards are saved

  Scenario: Should get two cards from the bottom of a shuffled deck
    When I play from the bottom
    Then I get two cards from the bottom from a shuffled deck
    And game cards are saved

  Scenario: Should get a list of all games
    Given I have played games
    When I ask for all the games
    Then I get a list of all played games
