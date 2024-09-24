package uz.itpu.dao;

import uz.itpu.entity.Tableware;

import java.sql.SQLException;
import java.util.List;

public interface DAOInterface<T extends Tableware<T>> {
    void insert(T item) throws SQLException;
    T showByIndex(long id);
    void update(T item);
    void delete(long id);
    List<T> showAll();
}

