package uz.itpu.dao.factory;

import uz.itpu.dao.DAOFactory;
import uz.itpu.dao.DAOInterface;
import uz.itpu.dao.PlateDAO;
import uz.itpu.entity.Tableware;

import java.sql.SQLException;

public class PlateFactory extends DAOFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T extends Tableware<T>> DAOInterface<T> createDao() throws SQLException {
        return (DAOInterface<T>) new PlateDAO();
    }
}
