package uz.itpu.controller;

import uz.itpu.entity.Cup;
import uz.itpu.service.CupService;

public class CupController extends AbstractController<Cup> {

    public CupController() {
        super(new CupService());
    }
}
