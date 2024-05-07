package com.amaap.troopsimulation.service;

import com.amaap.troopsimulation.domain.service.Train;
import com.amaap.troopsimulation.repository.db.impl.InMemoryFakeDatabase;
import com.amaap.troopsimulation.repository.impl.InMemoryTrainedTrooperRepository;
import com.amaap.troopsimulation.repository.impl.InMemoryTrooperRepository;
import com.amaap.troopsimulation.service.exception.InvalidTroopCountException;
import com.google.inject.Inject;

import java.util.List;

public class BarrackService {
    private final InMemoryTrooperRepository troopRepository;
    private final InMemoryTrainedTrooperRepository inMemoryTrainedTrooperRepository;
    private final Train train;

   @Inject
    public BarrackService(InMemoryFakeDatabase fakeDatabase) {
        this.troopRepository = InMemoryTrooperRepository.getInstance(fakeDatabase);
        this.inMemoryTrainedTrooperRepository =InMemoryTrainedTrooperRepository.getInstance(fakeDatabase);
        this.train = new Train(troopRepository, inMemoryTrainedTrooperRepository);
    }
    public  boolean trainTroopers(List<Object> troopers) throws InvalidTroopCountException {
        if (troopers.size() == 0) {
            throw new InvalidTroopCountException("No Troopers Found To train...");
        }

        return train.trainTroopers();
    }
}
