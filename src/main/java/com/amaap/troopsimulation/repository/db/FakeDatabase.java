package com.amaap.troopsimulation.repository.db;

import com.amaap.troopsimulation.service.exception.InvalidTroopTypeException;

import java.util.List;

public interface FakeDatabase {

    void insertIntoTroopTable(int troopCount, String troopType) throws InvalidTroopTypeException;

    List<Object> getTroopers();

    void insertIntoTrainedTrooperTable(Object trainedTrooper);

    List<Object> getTrainedTroopers();

    void setTrainedArcherCount(int archerCount);

    void setTrainedBarbarianCount(int barbarianCount);

    int getTrainedArcherCount();

    int getTrainedBarbarianCount();


}
