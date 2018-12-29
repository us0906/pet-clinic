package net.ulrichschulte.lernen.petclinic.controllers;

import net.ulrichschulte.lernen.petclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/vets")
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping ({"","/index", "/index.html","/vets.html"})
    public String listVets(Model model){

        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}
