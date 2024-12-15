package uz.itpu.controller;

import uz.itpu.entity.Spoon;
import uz.itpu.service.SpoonService;

public class SpoonController extends AbstractController<Spoon>{

    public SpoonController() {
        super(new SpoonService());
    }
}
