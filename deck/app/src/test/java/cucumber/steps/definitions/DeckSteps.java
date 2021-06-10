package cucumber.steps.definitions;

import com.ciandt.deck.CardDeck;
import com.ciandt.deck.playingcard.PlayingCard;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.github.tomakehurst.wiremock.client.WireMock;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.config.SpringIntegrationTest;
import cucumber.config.utils.RestUtils;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@AllArgsConstructor

public class DeckSteps extends SpringIntegrationTest {

    private RestUtils restUtils;

    @When ("the microservice is up$")
    public void theMicroserviceIsUp(){
        ResponseEntity<String> deckResponse = restUtils.get("/");
        testContext .setResponse(deckResponse);


    }

    @Then("the microservice generates a deck of cards$")
    public void theMicroserviceGeneratesADeckOfCards() throws JsonProcessingException {

        ResponseEntity<String> response = testContext.getResponse();
        List<PlayingCard> deck = objectMapper.readValue(response.getBody(), new TypeReference<List<PlayingCard>>() {   });



        assertAll(
                () -> assertEquals(52, deck.size()),
                () -> assertEquals(4, deck.stream().map(c -> c.getSuit()).distinct().count()),
                () -> assertEquals(13, deck.stream().map(c -> c.getValue()).distinct().count())
        );
    }
}
