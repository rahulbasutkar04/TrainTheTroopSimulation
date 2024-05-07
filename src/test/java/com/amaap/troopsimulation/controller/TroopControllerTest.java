package com.amaap.troopsimulation.controller;

import com.amaap.troopsimulation.controller.dto.HttpStatus;
import com.amaap.troopsimulation.controller.dto.Response;
import com.amaap.troopsimulation.repository.db.impl.InMemoryFakeDatabase;
import com.amaap.troopsimulation.repository.impl.InMemoryTrooperRepository;
import com.amaap.troopsimulation.service.TroopService;
import com.amaap.troopsimulation.service.exception.InvalidTroopCountException;
import com.amaap.troopsimulation.service.exception.InvalidTroopTypeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TroopControllerTest {
    InMemoryTrooperRepository inMemoryTrooperRepository;
    TroopService troopService;
    TroopController troopController;

    @BeforeEach
    void setup() {
        InMemoryFakeDatabase inMemoryFakeDatabase = new InMemoryFakeDatabase();
        inMemoryTrooperRepository = InMemoryTrooperRepository.getInstance(inMemoryFakeDatabase);
        troopService = new TroopService(inMemoryTrooperRepository);
        troopController = new TroopController(troopService);
        inMemoryFakeDatabase.clearDatabase();
    }

    @Test
    void shouldBeAbleToCreateTroopAndGetOKResponse() throws InvalidTroopCountException, InvalidTroopTypeException {
        // arrange
        int troopCount = 10;
        String troopType = "Barbarian";

        Response expected = new Response(HttpStatus.OK);

        // act
        Response actual = troopController.createTroop(troopCount, troopType);

        // assert
        assertEquals(expected, actual);
    }


    @Test
    void shouldBeAbleToGetBadRequestIfInvalidTroopTypeIsGiven() throws InvalidTroopCountException, InvalidTroopTypeException {
        // arrange
        int troopCount = 10;
        String troopType = "Truckers";

        Response expected = new Response(HttpStatus.BADREQUEST);

        // act
        Response actual = troopController.createTroop(troopCount, troopType);

        // assert
        assertEquals(expected, actual);
    }

}
