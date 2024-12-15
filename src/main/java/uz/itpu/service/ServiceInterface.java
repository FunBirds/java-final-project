package uz.itpu.service;

import uz.itpu.entity.Tableware;

import java.util.List;

public interface ServiceInterface<A extends Tableware<A>> {
    void insert(A item);
    A showByIndex(long id);
    void delete(long id);
    List<A> showAll();
}