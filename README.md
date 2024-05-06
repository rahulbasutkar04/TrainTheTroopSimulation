# Troop Training Simulation

## Problem Statement

Troop training simulation is inspired from Clash of Clans games. As a gaming programmer, you have to create a simulation software using which gamers can train army troops.

### Army Troops

There are two kinds of troops: Archers and Barbarians. Each trooper (archer/barbarian) has the following characteristics:

- *Barbarian* (Weapon: Sword)
    - Training Time (seconds): 3
    - Training Cost (magic potions): 10

- *Archer* (Weapon: Bow and Arrow)
    - Training Time (seconds): 6
    - Training Cost (magic potions): 20

### Barracks

Barracks are where each trooper gets trained. The following rules apply to barracks:
- Only one trooper can be trained at a given point of time.
- The maximum seat capacity of a barracks is 10.
- Others have to wait outside the barracks.
- Barracks can have a mix of troopers, e.g., 5 Archers and 5 Barbarians, or 4 Archers and 6 Barbarians, or 10 Archers, or 10 Barbarians.

### Army Camp

The army camp is where troops assemble after training.

## Scenario 1

Simulate the training and train barbarians and/or archers. As a gamer:

1. You should be able to input the number of barbarians and/or archers you would like to train.
2. You should be able to see how many troops are trained and available in the troop camp after training completes.

# OOMD Analysis
---
## Domain Model

### Troop
- *TroopType* (Enum)
    - Barbarian (class)
    - Archer (class)

### Barracks
- *Behaviours*
    - public void trainTroops()
    - private void trainTrooperAndWait(Barbarian barbarian)
    - private void trainTrooperAndWait(Archer archer)
    - `public void transferTrainedTroopsToArmyCamp(ArmyCamp armyCamp)

### ArmyCamp
- *Behaviour*
    - public void receiveTrainedTroops(LinkedList<Barbarian> barbarians, LinkedList<Archer> archers)
-----
## Service
- *TrooperService*
    - Provides training time & cost
- *BarrackService(Max Capacity)*
    -  train
- *ArmyCampService*
    - Views the trained troopers in the army camp

## Controller

### Trooper(trooperCount, troopType)
- Calls TrooperService for validation
- Service interacts with repository (InMemoryTroopRepository)

### Barrack
- Calls BarrackService
- get from InMemoryBarrackRepository

### ArmyCamp
- calls ArmyCampService
- get from InMemoryArmyCampRepository

## Repository
### InMemoryTroopRepository
### InMemoryBarrackRepository
### InMemoryArmyCampRepository
### InMemoryTrainedTroopRepository

## db
### FakeInMemoryDatabase
