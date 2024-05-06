package com.amaap.troopsimulation.repository;

import com.amaap.troopsimulation.service.exception.InvalidTroopTypeException;

import java.util.List;

public interface TroopRepository {
    void insert(int troopCount, String troopType) throws InvalidTroopTypeException, InvalidTroopTypeException;

    List<Object> getBarbarians();

    List<Object> getArchers();

    List<Object> getTroopers();
}