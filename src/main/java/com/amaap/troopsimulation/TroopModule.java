package com.amaap.troopsimulation;
import com.amaap.troopsimulation.repository.TrainedTroopRepository;
import com.amaap.troopsimulation.repository.TroopRepository;
import com.amaap.troopsimulation.repository.db.FakeDatabase;
import com.amaap.troopsimulation.repository.db.impl.InMemoryFakeDatabase;
import com.amaap.troopsimulation.repository.impl.InMemoryTrainedTrooperRepository;
import com.amaap.troopsimulation.repository.impl.InMemoryTrooperRepository;
import com.amaap.troopsimulation.service.BarrackService;
import com.amaap.troopsimulation.service.TroopService;
import com.google.inject.AbstractModule;

public class TroopModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(FakeDatabase.class).to(InMemoryFakeDatabase.class);
        bind(TroopRepository.class).to(InMemoryTrooperRepository.class);
        bind(TrainedTroopRepository.class).to(InMemoryTrainedTrooperRepository.class);
        bind(InMemoryTrooperRepository.class).toInstance(InMemoryTrooperRepository.getInstance(new InMemoryFakeDatabase()));
        bind(InMemoryTrainedTrooperRepository.class).toInstance(InMemoryTrainedTrooperRepository.getInstance(new InMemoryFakeDatabase()));
        bind(TroopService.class);
        bind(BarrackService.class);
    }
}
