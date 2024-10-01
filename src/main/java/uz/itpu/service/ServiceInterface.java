package uz.itpu.service;

public interface ServiceInterface<A> {
    void insert(A item);
    A showByIndex(long id);
    void delete(long id);
    A showAll();
}
