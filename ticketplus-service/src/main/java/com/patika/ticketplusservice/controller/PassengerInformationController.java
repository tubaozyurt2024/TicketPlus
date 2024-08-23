package com.patika.ticketplusservice.controller;


import com.patika.ticketplusservice.request.PassengerRequest;
import com.patika.ticketplusservice.request.UpdatePassengerRequest;
import com.patika.ticketplusservice.response.PassengerResponse;
import com.patika.ticketplusservice.service.PassengerInformationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/passenger")
public class PassengerInformationController {

    Logger logger = Logger.getLogger(PassengerInformationController.class.getName());

    private final PassengerInformationService passengerService;

    public PassengerInformationController(PassengerInformationService passengerService) {
        this.passengerService = passengerService;
    }

    @PostMapping
    public ResponseEntity<PassengerResponse> create(@RequestBody PassengerRequest passengerRequest) throws Exception {
        PassengerResponse status = passengerService.create(passengerRequest);
        logger.log(Level.INFO, "[PassengerInformationController] -- passenger created: " + passengerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(status);
    }

    @GetMapping
    public ResponseEntity<List<PassengerResponse>> getAll() throws Exception {
        List<PassengerResponse> passengers = passengerService.getAll();
        logger.log(Level.INFO, "[PassengerInformationController] -- passengers retrieved successfully. ");
        return ResponseEntity.ok(passengers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassengerResponse> getPassenger(@PathVariable("id") Integer id) throws Exception {
        PassengerResponse passengerResponse = passengerService.getPassenger(id);
        logger.log(Level.INFO, "[PassengerInformationController] -- passenger with id {0} retrieved. ", new Object[]{id});
        return ResponseEntity.ok(passengerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PassengerResponse> updatePassenger(@PathVariable("id") Integer id,
                                                             @RequestBody UpdatePassengerRequest updatePassengerRequest) throws Exception {
        PassengerResponse passengerResponse = passengerService.update(id, updatePassengerRequest);
        return ResponseEntity.ok(passengerResponse);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        passengerService.delete(id);
    }
}
