package uz.itpu.service;

import uz.itpu.dao.DAOInterface;
import uz.itpu.dao.factory.CupFactory;
import uz.itpu.entity.Cup;

import java.sql.SQLException;

public class CupService implements ServiceInterface<Cup>{

    private final DAOInterface<Cup> cupDAO;

    public CupService() throws SQLException {
        CupFactory cupFactory = new CupFactory();
        this.cupDAO = cupFactory.createDao();
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
