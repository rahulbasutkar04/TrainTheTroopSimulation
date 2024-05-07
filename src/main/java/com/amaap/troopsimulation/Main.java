package com.amaap.troopsimulation;

import com.amaap.troopsimulation.controller.BarrackController;
import com.amaap.troopsimulation.controller.TroopController;
import com.amaap.troopsimulation.repository.impl.InMemoryTrainedTrooperRepository;
import com.amaap.troopsimulation.repository.impl.InMemoryTrooperRepository;
import com.amaap.troopsimulation.service.BarrackService;
import com.amaap.troopsimulation.service.TroopService;
import com.amaap.troopsimulation.service.exception.InvalidTroopCountException;
import com.amaap.troopsimulation.service.exception.InvalidTroopTypeException;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidTroopCountException, InvalidTroopTypeException {
        Injector injector = Guice.createInjector(new TroopModule());
        TroopService troopService = injector.getInstance(TroopService.class);
        BarrackService barrackService = injector.getInstance(BarrackService.class);
        InMemoryTrooperRepository inMemoryTrooperRepository = injector.getInstance(InMemoryTrooperRepository.class);
        InMemoryTrainedTrooperRepository inMemoryTrainedTrooperRepository = injector.getInstance(InMemoryTrainedTrooperRepository.class);
        TroopController troopController = new TroopController(troopService);
        BarrackController barrackController = new BarrackController(inMemoryTrooperRepository, barrackService);

        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("troop-training > start-training");
            System.out.println("1. train troops.");
            System.out.println("2. view troop camp");
            System.out.println("0. exit");
            System.out.print("What do you want to do ? ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("1. Archer");
                    System.out.println("2. Barbarian");
                    System.out.print("Which troop do you want to train ? ");
                    int troopChoice = scanner.nextInt();
                    System.out.print("How many troops do you want to train ? ");
                    int troopCount = scanner.nextInt();

                    String troopType;
                    switch (troopChoice) {
                        case 1:
                            troopType = "Archer";
                            break;
                        case 2:
                            troopType = "Barbarian";
                            break;
                        default:
                            System.out.println("Invalid troop choice.");
                            continue;
                    }

                    troopController.createTroop(troopCount, troopType);
                    barrackController.train();
                    break;

                case 2:
                    System.out.println("Trained Barbarian:" + inMemoryTrainedTrooperRepository.getTrainedBarbarianCount());
                    System.out.println("Trained Archer:" + inMemoryTrainedTrooperRepository.getTrainedArcherCount());

                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Exiting the troop training simulation. Goodbye!");
    }

}


