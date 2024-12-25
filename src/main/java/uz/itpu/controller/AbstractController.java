package uz.itpu.controller;

import uz.itpu.entity.Tableware;
import uz.itpu.service.ServiceInterface;

import java.util.List;

public abstract class AbstractController<A extends Tableware<A>> implements ControllerInterface<A> {

    protected final ServiceInterface<A> service;

    public AbstractController(ServiceInterface<A> service) {
        this.service = service;
    }

    public void insert(A tableware) {
        this.service.insert(tableware);
    }

    public List<A> showByIndex(long index) {
        return this.service.showByIndex(index);
    }

    public List<A> showAll() {
        return this.service.showAll();
    }

    public void delete(long index) {
        this.service.delete(index);
    }
}
