package com.amaap.troopsimulation.repository.impl;

import com.amaap.troopsimulation.repository.TroopRepository;
import com.amaap.troopsimulation.repository.db.impl.InMemoryFakeDatabase;
import com.amaap.troopsimulation.service.exception.InvalidTroopTypeException;
import com.google.inject.Inject;

import java.util.List;

public class InMemoryTrooperRepository implements TroopRepository {
    private static InMemoryTrooperRepository instance;
    private final InMemoryFakeDatabase inMemoryFakeDatabase;

    @Inject
    private InMemoryTrooperRepository(InMemoryFakeDatabase inMemoryFakeDatabase) {
        this.inMemoryFakeDatabase = inMemoryFakeDatabase;
    }

    public static synchronized InMemoryTrooperRepository getInstance(InMemoryFakeDatabase inMemoryFakeDatabase) {
        if (instance == null) {
            instance = new InMemoryTrooperRepository(inMemoryFakeDatabase);
        }
        return instance;
    }

    @Override
    public void insert(int troopCount, String troopType) throws InvalidTroopTypeException {
        inMemoryFakeDatabase.insertIntoTroopTable(troopCount, troopType);
    }

    @Override
    public List<Object> getTroopers() {
        return inMemoryFakeDatabase.getTroopers();
    }
}
