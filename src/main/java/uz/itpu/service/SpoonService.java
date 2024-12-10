package uz.itpu.service;

import uz.itpu.dao.DAOInterface;
import uz.itpu.dao.factory.SpoonFactory;
import uz.itpu.entity.Spoon;

import java.sql.SQLException;

public class SpoonService implements ServiceInterface<Spoon> {
    SpoonFactory spoonFactory = new SpoonFactory();
    private final DAOInterface<Spoon> spoonDAO;

    public SpoonService() {
        try {
            spoonDAO = spoonFactory.createDao();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(Spoon item) {
        try {
            spoonDAO.insert(item);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Spoon showByIndex(long id) {
        try {
            spoonDAO.showByIndex(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        spoonDAO.delete(id);
    }

    @Override
    public Spoon showAll() {
        try {
            spoonDAO.showAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
