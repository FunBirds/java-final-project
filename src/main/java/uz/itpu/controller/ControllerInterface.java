package uz.itpu.controller;

import uz.itpu.entity.Tableware;

import java.util.List;

public interface ControllerInterface<A extends Tableware<A>> {
    void insert(A tableware);
    A showByIndex(long index);
    List<A> showAll();
    void delete(long index);
}