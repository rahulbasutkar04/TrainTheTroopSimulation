package com.amaap.troopsimulation.repository;

import com.amaap.troopsimulation.repository.db.impl.InMemoryFakeDatabase;
import com.amaap.troopsimulation.service.exception.InvalidTroopTypeException;

import java.util.List;

public class InMemoryTrooperRepository implements TroopRepository {

    private final InMemoryFakeDatabase inMemoryFakeDatabase;

    public InMemoryTrooperRepository(InMemoryFakeDatabase inMemoryFakeDatabase) {
        this.inMemoryFakeDatabase = inMemoryFakeDatabase;
    }


    @Override
    public void insert(int troopCount, String troopType) throws InvalidTroopTypeException {
        inMemoryFakeDatabase.insertIntoTroopTable(troopCount, troopType);
    }


    @Override
    public List<Object> getBarbarians() {
        return inMemoryFakeDatabase.getTroopers();
    }

    @Override
    public List<Object> getArchers() {
        return inMemoryFakeDatabase.getTroopers();
    }

    @Override
    public List<Object> getTroopers() {
        return inMemoryFakeDatabase.getTroopers();
    }
}
