package com.amaap.troopsimulation.controller;

import com.amaap.troopsimulation.controller.dto.HttpStatus;
import com.amaap.troopsimulation.controller.dto.Response;
import com.amaap.troopsimulation.repository.db.impl.InMemoryFakeDatabase;
import com.amaap.troopsimulation.repository.impl.InMemoryTrooperRepository;
import com.amaap.troopsimulation.service.BarrackService;
import com.amaap.troopsimulation.service.TroopService;
import com.amaap.troopsimulation.service.exception.InvalidTroopCountException;
import com.amaap.troopsimulation.service.exception.InvalidTroopTypeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BarrackControllerTest {
    InMemoryFakeDatabase fakeDatabase;
    InMemoryTrooperRepository inMemoryTrooperRepository;
    TroopController troopController;
    BarrackService barrackService;

    @BeforeEach
    void setup() {
        fakeDatabase = new InMemoryFakeDatabase();
        inMemoryTrooperRepository =InMemoryTrooperRepository.getInstance(fakeDatabase);
        troopController = new TroopController(new TroopService(inMemoryTrooperRepository));
        barrackService = new BarrackService(fakeDatabase);


    }

    @Test
    void shouldBeAbleToRespondOkWhenTroopersAreSentToTrainFromBarrackAndGetTrained() throws InvalidTroopCountException, InvalidTroopTypeException {
        // arrange
        int troopCount = 12;
        String troopType = "Barbarian";
        troopController.createTroop(troopCount, troopType);
        Response expected = new Response(HttpStatus.OK);
        BarrackController barrackController = new BarrackController(inMemoryTrooperRepository,barrackService);
        System.out.println(inMemoryTrooperRepository.getTroopers());

        // act
        Response actual = barrackController.train();
        //assert
        assertEquals(expected, actual);

    }


}
