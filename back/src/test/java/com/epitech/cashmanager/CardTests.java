package com.epitech.cashmanager;

import com.epitech.cashmanager.model.Card;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CashManagerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CardTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testGetAllCards() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/cards",
                HttpMethod.GET, entity, String.class);

        Assert.assertNotNull(response.getBody());
    }

    @Test
    public void testGetCardById() {
        Card card = restTemplate.getForObject(getRootUrl() + "/cards/1", Card.class);
        System.out.println(card.getName());
        Assert.assertNotNull(card);
    }

    @Test
    public void testCreateCard() {
        Card card = new Card();
        card.setName("name");
        card.setAmount(10);
        card.setAuthorize(true);

        ResponseEntity<Card> postResponse = restTemplate.postForEntity(getRootUrl() + "/cards", card, Card.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdatePost() {
        int id = 1;
        Card card = restTemplate.getForObject(getRootUrl() + "/cards/" + id, Card.class);
        card.setName("card1");

        restTemplate.put(getRootUrl() + "/cards/" + id, card);

        Card updatedCard = restTemplate.getForObject(getRootUrl() + "/cards/" + id, Card.class);
        Assert.assertNotNull(updatedCard);
    }

    @Test
    public void testDeletePost() {
        int id = 2;
        Card card = restTemplate.getForObject(getRootUrl() + "/cards/" + id, Card.class);
        Assert.assertNotNull(card);

        restTemplate.delete(getRootUrl() + "/cards/" + id);

        try {
            card = restTemplate.getForObject(getRootUrl() + "/cards/" + id, Card.class);
        } catch (final HttpClientErrorException e) {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}