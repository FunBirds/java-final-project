package uz.itpu;

import uz.itpu.controller.CupController;
import uz.itpu.dao.DAOInterface;
import uz.itpu.dao.factory.CupFactory;
import uz.itpu.entity.Cup;
import uz.itpu.service.CupService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        CupFactory cupFactory = new CupFactory();
        DAOInterface<Cup> cupDAO = cupFactory.createDao();
        System.out.println(cupDAO.showAll());

        CupService cupService = new CupService();
        System.out.println(cupService.showAll());

        CupController cupController = new CupController(cupService);
        System.out.println(cupController.showAll());
    }
}

