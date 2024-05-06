package com.amaap.troopsimulation.service;

import com.amaap.troopsimulation.repository.InMemoryTrooperRepository;
import com.amaap.troopsimulation.repository.db.FakeDatabase;
import com.amaap.troopsimulation.repository.db.impl.InMemoryFakeDatabase;
import com.amaap.troopsimulation.service.exception.InvalidTroopCountException;
import com.amaap.troopsimulation.service.exception.InvalidTroopTypeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TroopServiceTest {

    private TroopService troopService;
    private  FakeDatabase fakeDatabase;
    @BeforeEach
    void setup() {
        fakeDatabase =new InMemoryFakeDatabase();
        troopService = new TroopService(new InMemoryTrooperRepository((InMemoryFakeDatabase) fakeDatabase));
    }

    @Test
    void shouldBeAbleToThrowErrorWhenInvalidNumberCountOfTroopIsGiven() {
        // act & assert
        assertThrows(InvalidTroopCountException.class, () -> {
            troopService.create(-1, "Barbarian");
        });
    }
    @Test
    void shouldBeAbleToCrateTheNumberOfBarbarians() throws InvalidTroopCountException, InvalidTroopTypeException {
        // arrange
        int troopCount = 10;
        String troopType = "Barbarian";

        // act
        troopService.create(troopCount, troopType);
        List<Object> actual = troopService.getBarbarians();

        // assert

        assertEquals(10, actual.size());
    }

    @Test
    void shouldBeAbleToCrateTheNumberOfArchers() throws InvalidTroopCountException, InvalidTroopTypeException {
        // arrange
        int troopCount = 10;
        String troopType = "Archer";

        // act
        troopService.create(troopCount, troopType);
        List<Object> actual = troopService.getArchers();

        // assert

        assertEquals(10, actual.size());
    }

    @Test
    void shouldBeAbleToGetTheTotalTrooper() throws InvalidTroopCountException, InvalidTroopTypeException {

        // arrange
        int BarbarianCount = 10;
        String Type1 = "Barbarian";

        int ArcherCount = 10;
        String Type2 = "Archer";

        troopService.create(BarbarianCount,Type1);
        troopService.create(ArcherCount,Type2);

        List<Object> totalTrooper=troopService.getTroopers();

        assertEquals(20,totalTrooper.size());


    }
}