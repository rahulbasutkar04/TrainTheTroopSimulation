package com.amaap.troopsimulation.repository.db.impl;

import com.amaap.troopsimulation.domain.model.Archer;
import com.amaap.troopsimulation.domain.model.Barbarian;
import com.amaap.troopsimulation.repository.db.FakeDatabase;
import com.amaap.troopsimulation.service.exception.InvalidTroopTypeException;

import java.util.ArrayList;
import java.util.List;

public class InMemoryFakeDatabase implements FakeDatabase {
    private List<Object> troopList = new ArrayList<>();
    private List<Object> trainedTroopers=new ArrayList<>();
    private int  archerCount=0;
    private  int barbarianCount=0;
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

    @Override
    public void insertIntoTrainedTrooperTable(Object trainedTrooperData) {
        trainedTroopers.add(trainedTrooperData);
    }

    @Override
    public List<Object> getTrainedTroopers() {
        return trainedTroopers;
    }

    @Override
    public void setTrainedArcherCount(int archerCount) {
                 this.archerCount=archerCount;
    }

    @Override
    public void setTrainedBarbarianCount(int barbarianCount) {
              this.barbarianCount=barbarianCount;
    }

    @Override
    public int getTrainedArcherCount() {
        return archerCount;
    }

    @Override
    public int getTrainedBarbarianCount() {
        return barbarianCount;
    }


    public void clearDatabase() {
        troopList.clear();
        trainedTroopers.clear();
        archerCount=0;
        barbarianCount=0;
    }

}
