package com.amaap.troopsimulation.controller;

import com.amaap.troopsimulation.controller.dto.HttpStatus;
import com.amaap.troopsimulation.controller.dto.Response;
import com.amaap.troopsimulation.repository.impl.InMemoryTrooperRepository;
import com.amaap.troopsimulation.service.BarrackService;
import com.amaap.troopsimulation.service.exception.InvalidTroopCountException;

public class BarrackController {
    private final InMemoryTrooperRepository inMemoryTrooperRepository;
    private  final BarrackService barrackService;

    public BarrackController(InMemoryTrooperRepository inMemoryTrooperRepository,BarrackService barrackService) {
        this.inMemoryTrooperRepository=inMemoryTrooperRepository;
        this.barrackService=barrackService;
    }

    public Response train() throws InvalidTroopCountException {
       boolean isTrained= barrackService.trainTroopers(inMemoryTrooperRepository.getTroopers());
        System.out.println(isTrained);
        if(!isTrained) return  new Response(HttpStatus.BADREQUEST);
        return new Response(HttpStatus.OK);
    }
}
