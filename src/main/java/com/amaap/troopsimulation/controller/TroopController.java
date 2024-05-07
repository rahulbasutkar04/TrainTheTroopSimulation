package com.amaap.troopsimulation.controller;

import com.amaap.troopsimulation.controller.dto.HttpStatus;
import com.amaap.troopsimulation.controller.dto.Response;
import com.amaap.troopsimulation.service.exception.InvalidTroopCountException;
import com.amaap.troopsimulation.service.exception.InvalidTroopTypeException;
import com.amaap.troopsimulation.service.TroopService;
import com.google.inject.Inject;

;import static com.amaap.troopsimulation.service.validator.TroopNameValidator.isTroopTypeValid;

public class TroopController {
    private TroopService troopService;

    @Inject
    public TroopController(TroopService troopService) {
        this.troopService = troopService;
    }

    public Response createTroop(int troopCount, String troopType) throws InvalidTroopCountException, InvalidTroopTypeException {
        if (isTroopTypeValid(troopType) && troopCount > 0) {
            troopService.create(troopCount, troopType);
            return new Response(HttpStatus.OK);
        }
        return new Response(HttpStatus.BADREQUEST);
    }


}

