package com.amaap.troopsimulation.repository;

import java.util.List;

public interface TrainedTroopRepository {

    void insertToTrainedTrooperTable(Object trainedTrooper);

    List<Object> getTrainedTroopers();


    void setTrainedArcherCount(int archerCount);

    void setTrainedBarbarianCount(int barbarianCount);

    int getTrainedArcherCount();

    int getTrainedBarbarianCount();
}
