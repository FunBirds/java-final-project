package uz.itpu.service;

import uz.itpu.dao.DAOInterface;
import uz.itpu.dao.factory.PlateFactory;
import uz.itpu.entity.Plate;

import java.sql.SQLException;

public class PlateService implements ServiceInterface<Plate> {
    PlateFactory plateFactory = new PlateFactory();
    DAOInterface<Plate> plateDAO;

    {
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
    public Plate showByIndex(long id) {
        try {
            plateDAO.showByIndex(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        plateDAO.delete(id);
    }

    @Override
    public Plate showAll() {
        try {
            plateDAO.showAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
