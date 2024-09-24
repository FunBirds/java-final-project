package uz.itpu;

import uz.itpu.dao.CupDAO;
import uz.itpu.dao.PlateDAO;
import uz.itpu.dao.SpoonDAO;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        CupDAO plate = new CupDAO();
        System.out.println(plate.showByIndex(1));
    }
}

