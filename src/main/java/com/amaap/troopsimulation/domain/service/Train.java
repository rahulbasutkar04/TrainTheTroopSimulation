package com.amaap.troopsimulation.domain.service;

import com.amaap.troopsimulation.domain.model.Archer;
import com.amaap.troopsimulation.domain.model.Barbarian;
import com.amaap.troopsimulation.repository.impl.InMemoryTrainedTrooperRepository;
import com.amaap.troopsimulation.repository.impl.InMemoryTrooperRepository;

import java.util.ArrayList;
import java.util.List;

public class Train {

    private static final int maxCapacity = 10;
    private final InMemoryTrooperRepository inMemoryTrooperRepository;
    private final InMemoryTrainedTrooperRepository inMemoryTrainedTrooperRepository;

    public Train(InMemoryTrooperRepository inMemoryTrooperRepository, InMemoryTrainedTrooperRepository inMemoryTrainedTrooperRepository) {
        this.inMemoryTrooperRepository = inMemoryTrooperRepository;
        this.inMemoryTrainedTrooperRepository = inMemoryTrainedTrooperRepository;
    }


    public boolean trainTroopers() {
        boolean isTrained = false;
        List<Object> troopQueue = inMemoryTrooperRepository.getTroopers();
        while (!troopQueue.isEmpty()) {
            List<Object> batchToTrain = troopQueue.subList(0, Math.min(maxCapacity, troopQueue.size()));

            System.out.println("Training batch...");
            for (int i = 0; i < batchToTrain.size(); i++) {
                Object trooper = batchToTrain.get(i);
                if (trooper instanceof Archer) {
                    Archer archer = (Archer) trooper;
                    try {
                        Thread.sleep(archer.getTrainingTime() * 100);
                        System.out.println("Archer trained:" + archer.getId());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    inMemoryTrainedTrooperRepository.insertToTrainedTrooperTable(archer);
                } else if (trooper instanceof Barbarian) {
                    Barbarian barbarian = (Barbarian) trooper;
                    try {
                        Thread.sleep(barbarian.getTrainingTime() * 100);
                        System.out.println("Barbarian trained:" + barbarian.getId());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    inMemoryTrainedTrooperRepository.insertToTrainedTrooperTable(barbarian);
                }
            }
            troopQueue.removeAll(batchToTrain);

            System.out.println("Remaining TO train:" + troopQueue.size());

        }

        if (inMemoryTrainedTrooperRepository.getTrainedTroopers().size() != 0) {
            isTrained = true;
        }
        printTrainedTroopsByType();


        return isTrained;
    }

    public void printTrainedTroopsByType() {

        List<Object> trainedTroops = inMemoryTrainedTrooperRepository.getTrainedTroopers();
        List<Integer> trainedArcherIds = new ArrayList<>();
        List<Integer> trainedBarbarianIds = new ArrayList<>();

        for (Object trooper : trainedTroops) {
            if (trooper instanceof Archer) {
                Archer archer = (Archer) trooper;
                trainedArcherIds.add(archer.getId());
            } else if (trooper instanceof Barbarian) {
                Barbarian barbarian = (Barbarian) trooper;
                trainedBarbarianIds.add(barbarian.getId());
            }
        }
        System.out.println("Trained Archers:" + trainedArcherIds.size());

        System.out.println("Trained Barbarians:" + trainedBarbarianIds.size());
    }


}


