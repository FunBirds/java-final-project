package uz.itpu;

import uz.itpu.ui.UI;

public class Main {
    public static void main(String[] args) {
        try {
            UI ui = new UI();
            ui.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

