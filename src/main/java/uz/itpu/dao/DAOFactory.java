package uz.itpu.dao;
import uz.itpu.entity.Tableware;
import java.sql.SQLException;

public class DAOFactory {

    @SuppressWarnings("unchecked")
    public <T extends Tableware<T>> DAOInterface<T>  createDao(String daoType) throws SQLException {
        if (daoType.equalsIgnoreCase("Cup")) {
            return (DAOInterface<T>) new CupDAO();
        }
        if (daoType.equalsIgnoreCase("Plate")) {
            return (DAOInterface<T>) new PlateDAO();
        }
        if (daoType.equalsIgnoreCase("Spoon")){
            return (DAOInterface<T>) new SpoonDAO();
        }
        throw new IllegalArgumentException("No such DAO type");
    }
}
