package uz.itpu.controller;

import uz.itpu.entity.Cup;
import uz.itpu.service.ServiceInterface;

public class CupController implements ControllerInterface<Cup> {
    private final ServiceInterface<Cup> service;

    public CupController(ServiceInterface<Cup> service) {
        this.service = service;
    }

    @Override
    public void insert(Cup tableware) {
        this.service.insert(tableware);
    }

    @Override
    public Cup showByIndex(long index) {
        return this.service.showByIndex(index);
    }

    @Override
    public Cup showAll() {
        return this.service.showAll();
    }

    @Override
    public void delete(long index) {
        this.service.delete(index);
    }
}
