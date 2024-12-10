package uz.itpu.service;

import uz.itpu.entity.Tableware;

public interface ServiceInterface<A extends Tableware<A>> {
    void insert(A item);
    A showByIndex(long id);
    void delete(long id);
    A showAll();
}