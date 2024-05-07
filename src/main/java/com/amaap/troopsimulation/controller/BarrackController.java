package com.amaap.troopsimulation.controller;

import com.amaap.troopsimulation.controller.dto.HttpStatus;
import com.amaap.troopsimulation.controller.dto.Response;
import com.amaap.troopsimulation.repository.impl.InMemoryTrooperRepository;
import com.amaap.troopsimulation.service.BarrackService;
import com.amaap.troopsimulation.service.exception.InvalidTroopCountException;
import com.google.inject.Inject;

public class BarrackController {
    private final InMemoryTrooperRepository inMemoryTrooperRepository;
    private final BarrackService barrackService;


    @Inject
    public BarrackController(InMemoryTrooperRepository inMemoryTrooperRepository, BarrackService barrackService) {
        this.inMemoryTrooperRepository = inMemoryTrooperRepository;
        this.barrackService = barrackService;
    }

    public Response train() {
        try {
            boolean isTrained = barrackService.trainTroopers(inMemoryTrooperRepository.getTroopers());
            if (!isTrained) {
                return new Response(HttpStatus.BADREQUEST);
            }
            return new Response(HttpStatus.OK);
        } catch (InvalidTroopCountException e) {
            return new Response(HttpStatus.BADREQUEST);
        }
    }
}
