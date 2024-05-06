package com.amaap.troopsimulation.controller;

import com.amaap.troopsimulation.controller.dto.HttpStatus;
import com.amaap.troopsimulation.controller.dto.Response;
import com.amaap.troopsimulation.repository.TroopRepository;
import com.amaap.troopsimulation.repository.db.FakeDatabase;
import com.amaap.troopsimulation.repository.db.impl.InMemoryFakeDatabase;
import com.amaap.troopsimulation.repository.impl.InMemoryTrooperRepository;
import com.amaap.troopsimulation.service.TroopService;
import com.amaap.troopsimulation.service.exception.InvalidTroopCountException;
import com.amaap.troopsimulation.service.exception.InvalidTroopTypeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BarrackControllerTest {
    FakeDatabase fakeDatabase;
    TroopRepository troopRepository;
    TroopService troopService;
    TroopController troopController;

    @BeforeEach
    void setup() {
        fakeDatabase = new InMemoryFakeDatabase();
        troopRepository = new InMemoryTrooperRepository((InMemoryFakeDatabase) fakeDatabase);
        troopService = new TroopService(troopRepository);
        troopController = new TroopController(troopService);
    }

    @Test
    void shouldBeAbleToRespondOkWhenTroopersAreSentToTrainFromBarrackAndGetTrained() throws InvalidTroopCountException, InvalidTroopTypeException {
        // arrange
        int troopCount = 10;
        String troopType = "Barbarian";
        troopController.createTroop(troopCount, troopType);
        Response expected = new Response(HttpStatus.OK);
        BarrackController barrackController = new BarrackController();

        // act
        Response actual = barrackController.train();

        //assert
        assertEquals(expected, actual);


    }


}
