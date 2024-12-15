package uz.itpu;

import uz.itpu.controller.CupController;

public class Main {
    public static void main(String[] args) {
        CupController cupController = new CupController();
        System.out.println(cupController.showAll());
    }
}

