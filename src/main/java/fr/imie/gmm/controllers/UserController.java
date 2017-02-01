package fr.imie.gmm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.imie.gmm.repositories.UserRepository;

@Controller
public class UserController {

	@Autowired
	protected UserRepository userRepo;

}
