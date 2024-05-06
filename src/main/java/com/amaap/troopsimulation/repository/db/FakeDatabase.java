package com.amaap.troopsimulation.repository.db;

import com.amaap.troopsimulation.service.exception.InvalidTroopTypeException;

import java.util.List;

public interface FakeDatabase {

    void insertIntoTroopTable(int troopCount,String troopType) throws InvalidTroopTypeException;

    List<Object> getTroopers();
}
