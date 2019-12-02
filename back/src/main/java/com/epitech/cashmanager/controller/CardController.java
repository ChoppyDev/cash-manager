package com.epitech.cashmanager.controller;

import com.epitech.cashmanager.model.Card;
import com.epitech.cashmanager.repository.CardRepository;
import com.epitech.cashmanager.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class CardController {

    @Autowired
    private CardRepository cardRepository;

    /**
     * Get all cards list.
     *
     * @return the list
     */
    @GetMapping("/cards")
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    /**
     * Gets cards by id.
     *
     * @param cardId the card id
     * @return the card by id
     * @throws ResourceNotFound the resource not found exception
     */

    @GetMapping("/cards/{id}")
    public ResponseEntity<Card> getCardsById(@PathVariable(value = "id") Long cardId)
            throws ResourceNotFound {
        Card card =
                cardRepository
                        .findById(cardId)
                        .orElseThrow(() -> new ResourceNotFound("Card not found on :: " + cardId));
        return ResponseEntity.ok().body(card);
    }

    /**
     * Create card.
     *
     * @param card the card
     * @return the card
     */
    @PostMapping("/cards")
    public Card createCard(@Valid @RequestBody Card card) {
        return cardRepository.save(card);
    }

    /**
     * Update card response entity.
     *
     * @param cardId the card id
     * @param cardDetails the card details
     * @return the response entity
     * @throws ResourceNotFound the resource not found exception
     */
    @PutMapping("/cards/{id}")
    public ResponseEntity<Card> updateCard(
            @PathVariable(value = "id") Long cardId, @Valid @RequestBody Card cardDetails)
            throws ResourceNotFound {

        Card card =
                cardRepository
                        .findById(cardId)
                        .orElseThrow(() -> new ResourceNotFound("Card not found on :: " + cardId));

        card.setName(cardDetails.getName());
        card.setAuthorize(cardDetails.getAuthorize());
        card.setUpdatedAt(new Date());
        card.setCreatedAt(new Date());
        card.setCreatedBy("User");
        final Card updatedCard = cardRepository.save(card);
        return ResponseEntity.ok(updatedCard);
    }

    /**
     * Delete card map.
     *
     * @param cardId the card id
     * @return the map
     * @throws Exception the exception
     */
    @DeleteMapping("/cards/{id}")
    public Map<String, Boolean> deleteCard(@PathVariable(value = "id") Long cardId) throws Exception {
        Card card =
                cardRepository
                        .findById(cardId)
                        .orElseThrow(() -> new ResourceNotFound("Card not found on :: " + cardId));

        cardRepository.delete(card);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}