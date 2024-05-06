package com.amaap.troopsimulation.repository.impl;

import com.amaap.troopsimulation.repository.TrainedTroopRepository;
import com.amaap.troopsimulation.repository.db.impl.InMemoryFakeDatabase;

import java.util.List;

public class InMemoryTrainedTrooperRepository implements TrainedTroopRepository {
    private final InMemoryFakeDatabase inMemoryFakeDatabase;

    public InMemoryTrainedTrooperRepository(InMemoryFakeDatabase inMemoryFakeDatabase) {
        this.inMemoryFakeDatabase = inMemoryFakeDatabase;
    }

    @Override
    public void insertToTrainedTrooperTable(Object trainedTrooper) {
        inMemoryFakeDatabase.insertIntoTrainedTrooperTable(trainedTrooper);

    }

    @Override
    public List<Object> getTrainedTroopers() {
        return inMemoryFakeDatabase.getTrainedTroopers();
    }

    public void clearTrainedTroopers() {
        inMemoryFakeDatabase.getTroopers().clear();
    }
}
