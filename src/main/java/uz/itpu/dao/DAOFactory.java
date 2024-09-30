package uz.itpu.dao;
import uz.itpu.entity.Tableware;
import java.sql.SQLException;

public abstract class DAOFactory {
    public abstract <T extends Tableware<T>> DAOInterface<T> createDao() throws SQLException;
}
