package com.amaap.troopsimulation.repository.impl;

import com.amaap.troopsimulation.repository.TrainedTroopRepository;
import com.amaap.troopsimulation.repository.db.impl.InMemoryFakeDatabase;
import com.google.inject.Inject;

import java.util.List;

public class InMemoryTrainedTrooperRepository implements TrainedTroopRepository {
    private final InMemoryFakeDatabase inMemoryFakeDatabase;
    private static InMemoryTrainedTrooperRepository instance;

    @Inject
    private InMemoryTrainedTrooperRepository(InMemoryFakeDatabase inMemoryFakeDatabase) {
        this.inMemoryFakeDatabase = inMemoryFakeDatabase;
    }

    public static InMemoryTrainedTrooperRepository getInstance(InMemoryFakeDatabase inMemoryFakeDatabase) {
        if (instance == null) {
            instance = new InMemoryTrainedTrooperRepository(inMemoryFakeDatabase);
        }
        return instance;
    }

    @Override
    public void insertToTrainedTrooperTable(Object trainedTrooper) {
        inMemoryFakeDatabase.insertIntoTrainedTrooperTable(trainedTrooper);
    }

    @Override
    public List<Object> getTrainedTroopers() {
        return inMemoryFakeDatabase.getTrainedTroopers();
    }

    @Override
    public void setTrainedArcherCount(int archerCount) {
        inMemoryFakeDatabase.setTrainedArcherCount(archerCount);
    }

    @Override
    public void setTrainedBarbarianCount(int barbarianCount) {
        inMemoryFakeDatabase.setTrainedBarbarianCount(barbarianCount);
    }

    @Override
    public int getTrainedArcherCount() {
        return inMemoryFakeDatabase.getTrainedArcherCount();
    }

    @Override
    public int getTrainedBarbarianCount() {
        return inMemoryFakeDatabase.getTrainedBarbarianCount();
    }


}
