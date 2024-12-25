package uz.itpu.service;

import uz.itpu.dao.DAOInterface;
import uz.itpu.dao.factory.CupFactory;
import uz.itpu.entity.Cup;

import java.sql.SQLException;
import java.util.List;

public class CupService implements ServiceInterface<Cup>{

    private final DAOInterface<Cup> cupDAO;

    public CupService() {
        try {
            CupFactory cupFactory = new CupFactory();
            this.cupDAO = cupFactory.createDao();
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
    public List<Cup> showByIndex(long id) {
        try {
           return cupDAO.showByIndex(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(long id) {
        cupDAO.delete(id);
    }

    @Override
    public List<Cup> showAll() {
        try {
            return cupDAO.showAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
