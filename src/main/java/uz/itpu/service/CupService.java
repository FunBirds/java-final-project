package uz.itpu.service;

import uz.itpu.dao.DAOInterface;
import uz.itpu.dao.factory.CupFactory;
import uz.itpu.entity.Cup;

import java.sql.SQLException;

public class CupService implements ServiceInterface<Cup>{
    CupFactory cupFactory = new CupFactory();
    DAOInterface<Cup> cupDAO;

    {
        try {
            cupDAO = cupFactory.createDao();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(Cup item) {
        try {
            cupDAO.insert(item);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Cup showByIndex(long id) {
        try {
            cupDAO.showByIndex(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        cupDAO.delete(id);
    }

    @Override
    public Cup showAll() {
        try {
            cupDAO.showAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
return null;
    }
}
