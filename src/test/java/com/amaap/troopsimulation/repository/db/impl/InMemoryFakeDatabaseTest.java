package com.amaap.troopsimulation.repository.db.impl;

import com.amaap.troopsimulation.domain.model.Archer;
import com.amaap.troopsimulation.domain.model.Barbarian;
import com.amaap.troopsimulation.service.exception.InvalidTroopTypeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryFakeDatabaseTest {

    private InMemoryFakeDatabase fakeDatabase;

    @BeforeEach
    public void setUp() {
        fakeDatabase = new InMemoryFakeDatabase();
    }

    @Test
    public void shouldBeAbleToTestInsertAndRetrieveBarbarians() throws InvalidTroopTypeException {
        // arrange
        int expectedBarbarianCount = 3;

        // act
        fakeDatabase.insertIntoTroopTable(expectedBarbarianCount, "Barbarian");
        List<Object> troopers = fakeDatabase.getTroopers();

        // assert
        assertEquals(expectedBarbarianCount, troopers.size());
        assertTrue(troopers.stream().allMatch(trooper -> trooper instanceof Barbarian));
    }

    @Test
    public void shouldBeAbleToTestInsertAndRetrieveArchers() throws InvalidTroopTypeException {
        // arrange
        int expectedArcherCount = 2;

        // act
        fakeDatabase.insertIntoTroopTable(expectedArcherCount, "Archer");
        List<Object> troopers = fakeDatabase.getTroopers();

        // assert
        assertEquals(expectedArcherCount, troopers.size());
        assertTrue(troopers.stream().allMatch(trooper -> trooper instanceof Archer));
    }

    @Test
    public void ShouldThrowExceptionWhenInsertInvalidTroopType() {
        // act & assert
        assertThrows(InvalidTroopTypeException.class, () -> {
            fakeDatabase.insertIntoTroopTable(1, "Knight");
        });
    }

    @Test
    void shouldBeAbleToInsertAndRetrieveTrainedTroopers() {
        // arrange
        Barbarian barbarian = new Barbarian();
        fakeDatabase.insertIntoTrainedTrooperTable(barbarian);

        // act
        List<Object> trainedTroopers = fakeDatabase.getTrainedTroopers();

        // assert
        assertEquals(1, trainedTroopers.size());
        assertTrue(trainedTroopers.contains(barbarian));
    }


    @Test
    void shouldBeAbleToSetAndRetrieveTrainedArcherCount() {
        // arrange
        int expectedArcherCount = 5;

        // act
        fakeDatabase.setTrainedArcherCount(expectedArcherCount);
        int retrievedArcherCount = fakeDatabase.getTrainedArcherCount();

        // assert
        assertEquals(expectedArcherCount, retrievedArcherCount);
    }

    @Test
    void shouldBeAbleToSetAndRetrieveTrainedBarbarianCount() {
        // arrange
        int expectedBarbarianCount = 3;

        // act
        fakeDatabase.setTrainedBarbarianCount(expectedBarbarianCount);
        int retrievedBarbarianCount = fakeDatabase.getTrainedBarbarianCount();

        // assert
        assertEquals(expectedBarbarianCount, retrievedBarbarianCount);
    }




}