package com.ciandt.deck;

import com.ciandt.deck.playingcard.PlayingCard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)

public class CardDeckControllerTest {

    @InjectMocks
    CardDeckController cardDeckController;

    @Test
    void testGetDeckFromController(){

        //Act
        List<PlayingCard> result = cardDeckController.getGreeting();
        //Assert
        assertAll(() -> assertEquals(52, result.size(), "There are 52 cards"),
                 () -> assertEquals(4, result.stream().map(c -> c.getSuit()).distinct().count(), "There are 4 suits"),
                 () -> assertEquals(13, result.stream().map(c -> c.getValue()).distinct().count(),
                         "There are 13 values")
         );
    }
}
