package uz.itpu.controller;

import uz.itpu.entity.Plate;
import uz.itpu.service.PlateService;


public class PlateController extends AbstractController<Plate> {

    public PlateController() {
        super(new PlateService());
    }
}