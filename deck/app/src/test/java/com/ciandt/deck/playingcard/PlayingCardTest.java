package com.ciandt.deck.playingcard;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.of;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

public class PlayingCardTest {

    @InjectMocks
    PlayingCard playingCard;

    @ParameterizedTest
    @MethodSource("provideCards")
    void compareToTest(PlayingCard c1, PlayingCard c2, boolean isGreater) {
        assertEquals(c1.compareTo(c2) > 0, isGreater,
                String.format("%s is not bigger than %s", c1.toString(), c2.toString()));
    }

    static Stream<Arguments> provideCards() {
        return Stream.of(of(new PlayingCard(2, CardSuit.SPADES), new PlayingCard(2, CardSuit.HEARTS), true),
                of(new PlayingCard(2, CardSuit.SPADES), new PlayingCard(3, CardSuit.HEARTS), false),
                of(new PlayingCard(1, CardSuit.SPADES), new PlayingCard(10, CardSuit.HEARTS), true),
                of(new PlayingCard(1, CardSuit.SPADES), new PlayingCard(1, CardSuit.HEARTS), true),
                of(new PlayingCard(13, CardSuit.DIAMONDS), new PlayingCard(12, CardSuit.SPADES), true)
        );
    }

    @Test
    void testValueFormated(){
        PlayingCard card1 = new PlayingCard(1, CardSuit.CLUBS);
        PlayingCard card2 = new PlayingCard(11, CardSuit.CLUBS);
        PlayingCard card3 = new PlayingCard(12, CardSuit.CLUBS);
        PlayingCard card4 = new PlayingCard(13, CardSuit.CLUBS);
        PlayingCard card5 = new PlayingCard(5, CardSuit.CLUBS);

        assertEquals(card1.getFormattedValue(), "A");
        assertEquals(card2.getFormattedValue(), "J");
        assertEquals(card3.getFormattedValue(), "Q");
        assertEquals(card4.getFormattedValue(), "K");
        assertEquals(card5.getFormattedValue(), "5");
    }

    @Test
    void testSuitFormated(){
        PlayingCard card1 = new PlayingCard(2, CardSuit.CLUBS);
        PlayingCard card2 = new PlayingCard(2, CardSuit.DIAMONDS);
        PlayingCard card3 = new PlayingCard(2, CardSuit.SPADES);
        PlayingCard card4 = new PlayingCard(2, CardSuit.HEARTS);

        assertEquals(card1.getFormattedSuit(), "♣");
        assertEquals(card2.getFormattedSuit(), "♦");
        assertEquals(card3.getFormattedSuit(), "♠");
        assertEquals(card4.getFormattedSuit(), "♥");
    }

    @Test
    void testFormatedToString(){
        PlayingCard card1 = new PlayingCard(1, CardSuit.CLUBS);
        PlayingCard card2 = new PlayingCard(11, CardSuit.DIAMONDS);
        PlayingCard card3 = new PlayingCard(12, CardSuit.SPADES);
        PlayingCard card4 = new PlayingCard(13, CardSuit.HEARTS);
        PlayingCard card5 = new PlayingCard(5, CardSuit.CLUBS);

        assertEquals(card1.toString(), "A♣");
        assertEquals(card2.toString(), "J♦");
        assertEquals(card3.toString(), "Q♠");
        assertEquals(card4.toString(), "K♥");
        assertEquals(card5.toString(), "5♣");
    }

    @Test
    void testCompare(){
        PlayingCard card1 = new PlayingCard(1, CardSuit.CLUBS);
        PlayingCard card2 = new PlayingCard(2, CardSuit.DIAMONDS);
        PlayingCard card3 = new PlayingCard(3, CardSuit.SPADES);
        PlayingCard card4 = new PlayingCard(4, CardSuit.HEARTS);
        PlayingCard card5 = new PlayingCard(4, CardSuit.CLUBS);

        assertTrue(card1.compareTo(card2) > 0);
        assertTrue(card2.compareTo(card1) < 0); // falha pq pegou um bug, corrigi no codigo.
        assertTrue(card2.compareTo(card3) < 0);
        assertTrue(card4.compareTo(card5) > 0);
        assertTrue(card3.compareTo(card3) == 0);
    }
}
