package fr.imie.gmm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AdministratorController {

	@RequestMapping(method=RequestMethod.GET, path="/admin")
    public String Admin(Model model) {
        return "admin_view";
    }
	
}
