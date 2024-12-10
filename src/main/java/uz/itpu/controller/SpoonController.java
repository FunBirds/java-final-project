package uz.itpu.controller;

import uz.itpu.entity.Spoon;
import uz.itpu.service.ServiceInterface;

public class SpoonController implements ControllerInterface<Spoon>{
    private final ServiceInterface<Spoon> service;

    public SpoonController(ServiceInterface<Spoon> service) {
        this.service = service;
    }

    @Override
    public void insert(Spoon tableware) {
        this.service.insert(tableware);
    }

    @Override
    public Spoon showByIndex(long index) {
        return this.service.showByIndex(index);
    }

    @Override
    public Spoon showAll() {
        return this.service.showAll();
    }

    @Override
    public void delete(long index) {
        this.service.delete(index);
    }
}
