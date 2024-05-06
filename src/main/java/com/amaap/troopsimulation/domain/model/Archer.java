package com.amaap.troopsimulation.domain.model;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Archer {
    private static final AtomicInteger idCounter = new AtomicInteger();
    private final int id;
    private final int trainingTime;
    private final int trainingCost;

    public Archer() {
        this.id = idCounter.incrementAndGet();
        this.trainingTime = 6;
        this.trainingCost = 20;
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
        if (!(o instanceof Archer)) return false;
        Archer archer = (Archer) o;
        return id == archer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Archer{id=" + id + ", trainingTime=" + trainingTime + ", trainingCost=" + trainingCost + "}";
    }
}
