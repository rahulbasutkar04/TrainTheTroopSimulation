package com.amaap.troopsimulation.domain.service;

import com.amaap.troopsimulation.controller.TroopController;
import com.amaap.troopsimulation.repository.TroopRepository;
import com.amaap.troopsimulation.repository.db.impl.InMemoryFakeDatabase;
import com.amaap.troopsimulation.repository.impl.InMemoryTrainedTrooperRepository;
import com.amaap.troopsimulation.repository.impl.InMemoryTrooperRepository;
import com.amaap.troopsimulation.service.TroopService;
import com.amaap.troopsimulation.service.exception.InvalidTroopCountException;
import com.amaap.troopsimulation.service.exception.InvalidTroopTypeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainTest {
    InMemoryFakeDatabase inMemoryFakeDatabase;
    TroopRepository troopRepository;
    TroopService troopService;
    TroopController troopController;
    InMemoryTrainedTrooperRepository inMemoryTrainedTrooperRepository;
    Train train;

    @BeforeEach
    void setup()
    {
        inMemoryFakeDatabase=new InMemoryFakeDatabase();
        troopRepository=InMemoryTrooperRepository.getInstance(inMemoryFakeDatabase);
        troopService=new TroopService(troopRepository);
        troopController=new TroopController(troopService);
        inMemoryTrainedTrooperRepository=InMemoryTrainedTrooperRepository.getInstance(inMemoryFakeDatabase);
        train=new Train((InMemoryTrooperRepository) troopRepository,inMemoryTrainedTrooperRepository);
        inMemoryFakeDatabase.clearDatabase();
    }

    @Test
    void shouldBeAbleToTrainTheTrooperAndAddToTrainedData() throws InvalidTroopCountException, InvalidTroopTypeException {
        // arrange
        int troopCount=9;
        String troopType="Archer";
        troopController.createTroop(troopCount,troopType);

        // act

        boolean isTrained=train.trainTroopers();
        // assert
        assertTrue(isTrained);
    }
    @Test
    void shouldBeAbleToTrainMixedTroopTypesAndAddToTrainedData() throws InvalidTroopCountException, InvalidTroopTypeException {
        // arrange
        int archerCount = 5;
        int barbarianCount = 5;
        troopController.createTroop(archerCount, "Archer");
        troopController.createTroop(barbarianCount, "Barbarian");

        // act
        boolean isTrained = train.trainTroopers();

        // assert
        assertTrue(isTrained);
    }

    @Test
    void shouldBeAbleToTrainTroopersWithInsufficientCapacity() throws InvalidTroopCountException, InvalidTroopTypeException {
        // arrange
        int troopCount = 15;
        troopController.createTroop(troopCount, "Archer");

        // act
        boolean isTrained = train.trainTroopers();

        // assert
        assertTrue(isTrained);
    }





}