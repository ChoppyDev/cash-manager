package com.epitech.cashmanager.controller;

import com.epitech.cashmanager.exception.ResourceNotFound;
import com.epitech.cashmanager.model.Cheque;
import com.epitech.cashmanager.repository.ChequeRepository;
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
public class ChequeController {

    @Autowired
    private ChequeRepository chequeRepository;

    /**
     * Get all cheques list.
     *
     * @return the list
     */
    @GetMapping("/cheques")
    public List<Cheque> getAllCheques() {
        return chequeRepository.findAll();
    }

    /**
     * Gets cheques by id.
     *
     * @param chequeId the cheque id
     * @return the cheque by id
     * @throws ResourceNotFound the resource not found exception
     */

    @GetMapping("/cheques/{id}")
    public ResponseEntity<Cheque> getChequesById(@PathVariable(value = "id") Long chequeId)
            throws ResourceNotFound {
        Cheque cheque =
                chequeRepository
                        .findById(chequeId)
                        .orElseThrow(() -> new ResourceNotFound("Cheque not found on :: " + chequeId));
        return ResponseEntity.ok().body(cheque);
    }

    /**
     * Create cheque.
     *
     * @param cheque the cheque
     * @return the cheque
     */
    @PostMapping("/cheques")
    public Cheque createCheque(@Valid @RequestBody Cheque cheque) {
        return chequeRepository.save(cheque);
    }

    /**
     * Update cheque response entity.
     *
     * @param chequeId      the cheque id
     * @param chequeDetails the cheque details
     * @return the response entity
     * @throws ResourceNotFound the resource not found exception
     */
    @PutMapping("/cheques/{id}")
    public ResponseEntity<Cheque> updateCheque(
            @PathVariable(value = "id") Long chequeId, @Valid @RequestBody Cheque chequeDetails)
            throws ResourceNotFound {

        Cheque cheque =
                chequeRepository
                        .findById(chequeId)
                        .orElseThrow(() -> new ResourceNotFound("Cheque not found on :: " + chequeId));

        cheque.setName(chequeDetails.getName());
        cheque.setAuthorize((chequeDetails.getAuthorize()));
        cheque.setUpdatedAt(new Date());
        cheque.setCreatedAt(new Date());
        cheque.setUpdatedBy(chequeDetails.getUpdatedBy());
        final Cheque updatedCheque = chequeRepository.save(cheque);
        return ResponseEntity.ok(updatedCheque);
    }

    /**
     * Delete cheque map.
     *
     * @param chequeId the cheque id
     * @return the map
     * @throws Exception the exception
     */
    @DeleteMapping("/cheques/{id}")
    public Map<String, Boolean> deleteCheque(@PathVariable(value = "id") Long chequeId) throws Exception {
        Cheque cheque =
                chequeRepository
                        .findById(chequeId)
                        .orElseThrow(() -> new ResourceNotFound("Cheque not found on :: " + chequeId));

        chequeRepository.delete(cheque);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}