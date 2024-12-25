package uz.itpu.service;

import uz.itpu.dao.DAOInterface;
import uz.itpu.dao.factory.PlateFactory;
import uz.itpu.entity.Plate;

import java.sql.SQLException;
import java.util.List;

public class PlateService implements ServiceInterface<Plate> {
    PlateFactory plateFactory = new PlateFactory();
    private final DAOInterface<Plate> plateDAO;

    public PlateService() {
        try {
            plateDAO = plateFactory.createDao();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(Plate item) {
        try {
            plateDAO.insert(item);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Plate> showByIndex(long id) {
        try {
            return plateDAO.showByIndex(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(long id) {
        plateDAO.delete(id);
    }

    @Override
    public List<Plate> showAll() {
        try {
           return plateDAO.showAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
