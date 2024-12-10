package uz.itpu.controller;

import uz.itpu.entity.Tableware;

public interface ControllerInterface<A extends Tableware<A>> {
    void insert(A tableware);
    A showByIndex(long index);
    A showAll();
    void delete(long index);
}