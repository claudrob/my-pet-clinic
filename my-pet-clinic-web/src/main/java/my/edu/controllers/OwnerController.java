package my.edu.controllers;

import my.edu.model.Owner;
import my.edu.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOwner(Model model){

        Set<Owner> set = ownerService.findAll();
        for(Owner o : set)
            System.out.println("OwnerController: " + o);
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }
}
