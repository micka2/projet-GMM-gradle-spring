package fr.imie.gmm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.imie.gmm.repositories.AdministratorRepository;


@Controller
public class AdministratorController {
	
	protected AdministratorRepository administratorRepo;
	
	@Autowired
	public AdministratorController(AdministratorRepository administratorRepository) {
		this.administratorRepo = administratorRepository;
	}

	@RequestMapping(method=RequestMethod.GET, path="/admin")
    public String Admin(Model model) {
        return "admin_view";
    }
	
}
