package com.amaap.troopsimulation;
import com.amaap.troopsimulation.controller.TroopController;
import com.amaap.troopsimulation.controller.dto.HttpStatus;
import com.amaap.troopsimulation.controller.dto.Response;
import com.amaap.troopsimulation.repository.InMemoryTrooperRepository;
import com.amaap.troopsimulation.repository.db.impl.InMemoryFakeDatabase;
import com.amaap.troopsimulation.service.exception.InvalidTroopCountException;
import com.amaap.troopsimulation.service.exception.InvalidTroopTypeException;
import com.amaap.troopsimulation.service.TroopService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TroopControllerTest {

     TroopController troopController=new TroopController(new TroopService(new InMemoryTrooperRepository(new InMemoryFakeDatabase())));

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
        String troopType = "Trunkers";

        Response expected = new Response(HttpStatus.BADREQUEST);

        // act
        Response actual = troopController.createTroop(troopCount, troopType);

        // assert
        assertEquals(expected, actual);
    }

}
