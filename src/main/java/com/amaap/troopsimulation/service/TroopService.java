package com.amaap.troopsimulation.service;

import com.amaap.troopsimulation.repository.TroopRepository;
import com.amaap.troopsimulation.service.exception.InvalidTroopCountException;
import com.amaap.troopsimulation.service.exception.InvalidTroopTypeException;
import com.google.inject.Inject;


public class TroopService {
    private final TroopRepository troopRepository;

    @Inject
    public TroopService(TroopRepository troopRepository) {
        this.troopRepository = troopRepository;
    }

    public void create(int troopCount, String troopType) throws InvalidTroopCountException, InvalidTroopTypeException {
        if (troopCount <= 0) throw new InvalidTroopCountException("Troop count can not be:" + troopCount);
        troopRepository.insert(troopCount, troopType);
    }

}
