package com.amaap.troopsimulation.service;

import com.amaap.troopsimulation.repository.TroopRepository;
import com.amaap.troopsimulation.service.exception.InvalidTroopCountException;
import com.amaap.troopsimulation.service.exception.InvalidTroopTypeException;

import java.util.List;

public class TroopService {
    private final TroopRepository troopRepository;

    public TroopService(TroopRepository troopRepository) {
        this.troopRepository = troopRepository;
    }

    public void create(int troopCount, String troopType) throws InvalidTroopCountException, InvalidTroopTypeException {
        if (troopCount <= 0) throw new InvalidTroopCountException("Troop count can not be:" + troopCount);
        troopRepository.insert(troopCount, troopType);
    }

    public List<Object> getBarbarians() {
        return troopRepository.getBarbarians();
    }


    public List<Object> getArchers() {
        return troopRepository.getArchers();
    }
    public List<Object> getTroopers(){
        return troopRepository.getTroopers();
    }
}
