package com.amaap.troopsimulation.domain;

public enum Troop {

    Barbarian("Barbarian"), Archer("Archer");

    private final String typeName;

    Troop(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
