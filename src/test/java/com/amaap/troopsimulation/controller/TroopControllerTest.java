package com.amaap.troopsimulation.controller;
import com.amaap.troopsimulation.controller.dto.HttpStatus;
import com.amaap.troopsimulation.controller.dto.Response;
import com.amaap.troopsimulation.repository.TroopRepository;
import com.amaap.troopsimulation.repository.impl.InMemoryTrooperRepository;
import com.amaap.troopsimulation.repository.db.impl.InMemoryFakeDatabase;
import com.amaap.troopsimulation.service.exception.InvalidTroopCountException;
import com.amaap.troopsimulation.service.exception.InvalidTroopTypeException;
import com.amaap.troopsimulation.service.TroopService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TroopControllerTest {
     InMemoryTrooperRepository inMemoryTrooperRepository=InMemoryTrooperRepository.getInstance(new InMemoryFakeDatabase());
     TroopService troopService=new TroopService(inMemoryTrooperRepository);
     TroopController troopController=new TroopController(troopService);

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
