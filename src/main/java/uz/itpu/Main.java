package uz.itpu;

import uz.itpu.dao.CupDAO;
import uz.itpu.entity.Cup;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        CupDAO cupDAO = new CupDAO();
        Cup newCup = new Cup()
                .setName("Ceramic Mug")
                .setMaterial("Ceramic")
                .setPrice(15)
                .setColor("Blue")
                .setVolume(300)
                .setSize(12);
        cupDAO.insert(newCup);
    }
}
