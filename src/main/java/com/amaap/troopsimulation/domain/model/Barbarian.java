
package com.amaap.troopsimulation.domain.model;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Barbarian {
    private static final AtomicInteger idCounter = new AtomicInteger();
    private final int id;
    private final int trainingTime;
    private final int trainingCost;

    public Barbarian() {
        this.id = idCounter.incrementAndGet();
        this.trainingTime = 3;
        this.trainingCost = 10;
    }

    public int getId() {
        return id;
    }

    public int getTrainingTime() {
        return trainingTime;
    }

    public int getTrainingCost() {
        return trainingCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Barbarian)) return false;
        Barbarian barbarian = (Barbarian) o;
        return id == barbarian.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Barbarian{id=" + id + ", trainingTime=" + trainingTime + ", trainingCost=" + trainingCost + "}";
    }

}
