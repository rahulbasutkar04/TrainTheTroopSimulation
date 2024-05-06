package com.amaap.troopsimulation.repository;

import java.util.List;

public interface TrainedTroopRepository {

    void insertToTrainedTrooperTable(Object trainedTrooper);

    List<Object> getTrainedTroopers();
}
