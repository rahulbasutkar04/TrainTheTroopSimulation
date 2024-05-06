package com.amaap.troopsimulation;

import com.amaap.troopsimulation.service.TroopService;

;

public class TroopController {
    private TroopService troopService;
    public TroopController(TroopService troopService) {
        this.troopService = troopService;
    }

    public Response createTroop(int troopCount, String troopType){
        if (isTroopTypeValid(troopType) && troopCount > 0) {
            troopService.create(troopCount, troopType);
            return new Response(HttpStatus.OK);
        }
        return new Response(HttpStatus.BADREQUEST);
    }


}

