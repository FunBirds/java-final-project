package uz.itpu.controller;

import uz.itpu.entity.Plate;
import uz.itpu.service.ServiceInterface;

public class PlateController implements ControllerInterface<Plate> {
    private final ServiceInterface<Plate> service;

    public PlateController(ServiceInterface<Plate> service) {
        this.service = service;
    }

    @Override
    public void insert(Plate tableware) {
        this.service.insert(tableware);
    }

    @Override
    public Plate showByIndex(long index) {
        return this.service.showByIndex(index);
    }

    @Override
    public Plate showAll() {
        return this.service.showAll();
    }

    @Override
    public void delete(long index) {
        this.service.delete(index);
    }
}