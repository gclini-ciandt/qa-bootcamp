Feature: Games

  Scenario: Should get two cards from the top of a shuffled deck
    When I play from the top
    Then I get two cards from the top from a shuffled deck
    And game cards are saved
