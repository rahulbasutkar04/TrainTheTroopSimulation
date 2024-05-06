package com.amaap.troopsimulation.service;

import com.amaap.troopsimulation.repository.impl.InMemoryTrooperRepository;
import com.amaap.troopsimulation.repository.db.impl.InMemoryFakeDatabase;
import com.amaap.troopsimulation.service.exception.InvalidTroopCountException;
import com.amaap.troopsimulation.service.exception.InvalidTroopTypeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TroopServiceTest {

    private TroopService troopService;
    private  InMemoryFakeDatabase inMemoryFakeDatabase;
    @BeforeEach
    void setup() {
        inMemoryFakeDatabase =new InMemoryFakeDatabase();
        InMemoryTrooperRepository inMemoryTrooperRepository=InMemoryTrooperRepository.getInstance(inMemoryFakeDatabase);
        troopService = new TroopService(inMemoryTrooperRepository);
    }

    @Test
    void shouldBeAbleToThrowErrorWhenInvalidNumberCountOfTroopIsGiven() {
        // act & assert
        assertThrows(InvalidTroopCountException.class, () -> {
            troopService.create(-1, "Barbarian");
        });
    }

    @Test
    void shouldBeAbleToGetTheTotalTrooper() throws InvalidTroopCountException, InvalidTroopTypeException {

        // arrange
        int BarbarianCount = 10;
        String Type1 = "Barbarian";
        int ArcherCount = 10;
        String Type2 = "Archer";

        // act
        troopService.create(BarbarianCount,Type1);
        troopService.create(ArcherCount,Type2);

        // assert
        List<Object> totalTrooper=inMemoryFakeDatabase.getTroopers();
        assertEquals(20,totalTrooper.size());
    }
}