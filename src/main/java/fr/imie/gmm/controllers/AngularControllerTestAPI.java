package fr.imie.gmm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.imie.gmm.entities.User;
import fr.imie.gmm.repositories.UserRepository;

@Controller
public class AngularControllerTestAPI {

	protected UserRepository userRepo;
	
	@Autowired
    public AngularControllerTestAPI(UserRepository userRepository) {
        this.userRepo = userRepository;
    }
	
	public AngularControllerTestAPI(){
		
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/api/1/teachers")
    public List<User> TestAngular(Model model) {
		
		List<User> users = (List<User>) this.userRepo.findAll();
		
        return users;
    }
}
