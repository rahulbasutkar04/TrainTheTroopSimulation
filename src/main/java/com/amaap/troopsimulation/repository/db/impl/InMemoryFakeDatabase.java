package com.amaap.troopsimulation.repository.db.impl;

import com.amaap.troopsimulation.domain.model.Archer;
import com.amaap.troopsimulation.domain.model.Barbarian;
import com.amaap.troopsimulation.repository.db.FakeDatabase;
import com.amaap.troopsimulation.service.exception.InvalidTroopTypeException;

import java.util.ArrayList;
import java.util.List;

public class InMemoryFakeDatabase implements FakeDatabase {
    private List<Object> troopList = new ArrayList<>();
    @Override
    public void insertIntoTroopTable(int troopCount, String troopType) throws InvalidTroopTypeException {
        if ("Barbarian".equals(troopType)) {
            for (int i = 0; i < troopCount; i++) {
                troopList.add(new Barbarian());
            }
        } else if ("Archer".equals(troopType)) {
            for (int i = 0; i < troopCount; i++) {
                troopList.add(new Archer());
            }
        } else {
            throw new InvalidTroopTypeException("Invalid troop type: " + troopType);
        }
    }

    @Override
    public List<Object> getTroopers() {
        return troopList;
    }
}
