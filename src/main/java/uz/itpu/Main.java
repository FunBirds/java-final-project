package uz.itpu;

import uz.itpu.dao.CupDAO;


import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        CupDAO cup = new CupDAO();
        System.out.println(cup.showAll());
    }
}

