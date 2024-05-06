package com.amaap.troopsimulation.repository;

import com.amaap.troopsimulation.repository.db.impl.InMemoryFakeDatabase;
import com.amaap.troopsimulation.service.exception.InvalidTroopTypeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryTrooperRepositoryTest {

    private InMemoryFakeDatabase fakeDatabase;
    private InMemoryTrooperRepository trooperRepository;

    @BeforeEach
    public void setUp() {
        fakeDatabase = new InMemoryFakeDatabase();
        trooperRepository = new InMemoryTrooperRepository(fakeDatabase);
    }

    @Test
    public void shouldBeAbleToTestInsertAndRetrieveBarbarians() throws InvalidTroopTypeException {
        // arrange
        int expectedBarbarianCount = 3;

        // act
        trooperRepository.insert(expectedBarbarianCount, "Barbarian");
        List<Object> barbarians = trooperRepository.getBarbarians();

        // assert
        assertEquals(expectedBarbarianCount, barbarians.size());
    }

    @Test
    public void shouldBeAbleToTestInsertAndRetrieveArchers() throws InvalidTroopTypeException {
        // arrange
        int expectedArcherCount = 2;

        // act
        trooperRepository.insert(expectedArcherCount, "Archer");
        List<Object> archers = trooperRepository.getArchers();

        // assert
        assertEquals(expectedArcherCount, archers.size());
    }

    @Test
    public void shouldBeAbleTestInsertAndRetrieveTroopers() throws InvalidTroopTypeException {
        // arrange
        int expectedBarbarianCount = 3;
        int expectedArcherCount = 2;
        int expectedTotalTroopers = expectedBarbarianCount + expectedArcherCount;

        // act
        trooperRepository.insert(expectedBarbarianCount, "Barbarian");
        trooperRepository.insert(expectedArcherCount, "Archer");
        List<Object> troopers = trooperRepository.getTroopers();

        // assert
        assertEquals(expectedTotalTroopers, troopers.size());
    }
}