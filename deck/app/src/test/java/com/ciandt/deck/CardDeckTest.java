package com.ciandt.deck;

import com.ciandt.deck.playingcard.CardSuit;
import com.ciandt.deck.playingcard.PlayingCard;
import org.junit.jupiter.api.Test;

import lombok.val;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static com.ciandt.deck.playingcard.CardSuit.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class
)

public class CardDeckTest {
    @Test
    void shouldHaveAllCards() {
        val cards = CardDeck.getDeck();

        assertAll(() -> assertEquals(52, cards.size(), "There are 52 cards"),
                () -> assertEquals(4, cards.stream().map(c -> c.getSuit()).distinct().count(), "There are 4 suits"),
                () -> assertEquals(13, cards.stream().map(c -> c.getValue()).distinct().count(),
                        "There are 13 values")
        );
       // System.out.println(cards);
    }

    @Test
    void shouldHaveAllSuits(){
        List<PlayingCard> cards = CardDeck.getDeck();
        assertEquals(4,cards.stream().map( c -> c.getSuit()).distinct().count());

    }

    @Test
    void shouldHaveAllValues(){
        List<PlayingCard> cards = CardDeck.getDeck();
        assertEquals(13,cards.stream().map( c -> c.getValue()).distinct().count());

    }

    @Test
    void shouldHaveAllCombinations(){

        //Arrange
        List<PlayingCard> cards = CardDeck.getDeck();

        PlayingCard minValueSpades = cards.stream().filter(e -> e.getSuit() == SPADES).min( Comparator.comparing( PlayingCard::getValue)).get();
        PlayingCard maxValueSpades = cards.stream().filter(e -> e.getSuit() == SPADES).max( Comparator.comparing( PlayingCard::getValue)).get();

        PlayingCard minValueDiamonds = cards.stream().filter(e -> e.getSuit() == DIAMONDS).min( Comparator.comparing( PlayingCard::getValue)).get();
        PlayingCard maxValueDiamonds = cards.stream().filter(e -> e.getSuit() == DIAMONDS).max( Comparator.comparing( PlayingCard::getValue)).get();

        PlayingCard minValueClubs = cards.stream().filter(e -> e.getSuit() == CLUBS).min( Comparator.comparing( PlayingCard::getValue)).get();
        PlayingCard maxValueClubs = cards.stream().filter(e -> e.getSuit() == CLUBS).max( Comparator.comparing( PlayingCard::getValue)).get();

        PlayingCard minValueHearts = cards.stream().filter(e -> e.getSuit() == HEARTS).min( Comparator.comparing( PlayingCard::getValue)).get();
        PlayingCard maxValueHearts = cards.stream().filter(e -> e.getSuit() == HEARTS).max( Comparator.comparing( PlayingCard::getValue)).get();

        // Assert
        assertAll (
                //SPADES VALIDATIONS
                () -> assertEquals(13, cards.stream().filter(e -> e.getSuit() == SPADES).distinct().count()),
                () -> assertEquals(1, minValueSpades.getValue()),
                () -> assertEquals(13, maxValueSpades.getValue()),
                // DIAMONDS VALIDATIONS
                () -> assertEquals(13, cards.stream().filter(e -> e.getSuit() == DIAMONDS).distinct().count()),
                () -> assertEquals(1, minValueDiamonds.getValue()),
                () -> assertEquals(13, maxValueDiamonds.getValue()),
                // CLUBS VALIDATIONS
                () -> assertEquals(13, cards.stream().filter(e -> e.getSuit() == CLUBS).distinct().count()),
                () -> assertEquals(1, minValueClubs.getValue()),
                () -> assertEquals(13, maxValueClubs.getValue()),
                // HEARTS VALIDATIONS
                () -> assertEquals(13, cards.stream().filter(e -> e.getSuit() == HEARTS).distinct().count()),
                () -> assertEquals(1, minValueHearts.getValue()),
                () -> assertEquals(13, maxValueHearts.getValue()),
                // TOTAL SIZE VALIDATION
                () -> assertEquals(52, cards.size())
        );
    }
}
