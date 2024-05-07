package com.amaap.troopsimulation.repository;


import com.amaap.troopsimulation.repository.db.impl.InMemoryFakeDatabase;
import com.amaap.troopsimulation.repository.impl.InMemoryTrainedTrooperRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InMemoryTrainedTrooperRepositoryTest {

    private InMemoryFakeDatabase fakeDatabase;
    private InMemoryTrainedTrooperRepository trainedTrooperRepository;

    @BeforeEach
    void setUp() {
        fakeDatabase = new InMemoryFakeDatabase();
        trainedTrooperRepository = InMemoryTrainedTrooperRepository.getInstance(fakeDatabase);
        fakeDatabase.clearDatabase();
    }

    @Test
    void shouldBeAbleToInsertAndRetrieveTrainedTroopers() {
        // arrange
        Object trainedTrooper = new Object();

        // act
        trainedTrooperRepository.insertToTrainedTrooperTable(trainedTrooper);
        var trainedTroopers = trainedTrooperRepository.getTrainedTroopers();

        // assert
        assertTrue(trainedTroopers.contains(trainedTrooper));
    }

    @Test
    void shouldBeAbleToRetrieveTrainedArcherCount() {
        // arrange
        int expectedArcherCount = 5;
        trainedTrooperRepository.setTrainedArcherCount(expectedArcherCount);

        // act
        int actualArcherCount = trainedTrooperRepository.getTrainedArcherCount();

        // assert
        assertEquals(expectedArcherCount, actualArcherCount);
    }

    @Test
    void shouldBeAbleToRetrieveTrainedBarbarianCount() {
        // arrange
        int expectedBarbarianCount = 3;
        trainedTrooperRepository.setTrainedBarbarianCount(expectedBarbarianCount);

        // act
        int actualBarbarianCount = trainedTrooperRepository.getTrainedBarbarianCount();

        // assert
        assertEquals(expectedBarbarianCount, actualBarbarianCount);
    }


}
