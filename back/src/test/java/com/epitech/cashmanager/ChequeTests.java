package com.epitech.cashmanager;

import com.epitech.cashmanager.model.Cheque;
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
class ChequeTests {

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
    public void testGetAllCheques() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/cheques",
                HttpMethod.GET, entity, String.class);

        Assert.assertNotNull(response.getBody());
    }

    @Test
    public void testGetChequeById() {
        Cheque cheque = restTemplate.getForObject(getRootUrl() + "/cheques/1", Cheque.class);
        System.out.println(cheque.getName());
        Assert.assertNotNull(cheque);
    }

    @Test
    public void testCreateCheque() {
        Cheque cheque = new Cheque();
        cheque.setName("name");
        cheque.setAmount(10);
        cheque.setAuthorize(true);

        ResponseEntity<Cheque> postResponse = restTemplate.postForEntity(getRootUrl() + "/cheques", cheque, Cheque.class);
        Assert.assertNotNull(postResponse);
        Assert.assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdatePost() {
        int id = 1;
        Cheque cheque = restTemplate.getForObject(getRootUrl() + "/cheques/" + id, Cheque.class);
        cheque.setName("cheque1");

        restTemplate.put(getRootUrl() + "/cheques/" + id, cheque);

        Cheque updatedCheque = restTemplate.getForObject(getRootUrl() + "/cheques/" + id, Cheque.class);
        Assert.assertNotNull(updatedCheque);
    }

    @Test
    public void testDeletePost() {
        int id = 2;
        Cheque cheque = restTemplate.getForObject(getRootUrl() + "/cheques/" + id, Cheque.class);
        Assert.assertNotNull(cheque);

        restTemplate.delete(getRootUrl() + "/cheques/" + id);

        try {
            cheque = restTemplate.getForObject(getRootUrl() + "/cheques/" + id, Cheque.class);
        } catch (final HttpClientErrorException e) {
            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }
}
