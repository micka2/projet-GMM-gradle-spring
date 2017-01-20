package fr.imie.gmm.contrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.imie.gmm.entities.User;
import fr.imie.gmm.repository.UserRepository;


@Controller
public class ConnectController {

	protected UserRepository userRepo;
	
	//private static final String VALID_LOGIN="toto";
	//private static final String VALID_PASSWORD="toto";

	
	@Autowired
	public ConnectController (UserRepository userRepo){
		this.userRepo= userRepo;
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET, path ="/login")
	public String login(Model model) {
		return "connect";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/checklogin")
	public String checklogin(@RequestParam(value = "email", required = false) 
			String email,
			@RequestParam(value = "password", required = false) 
			String password, 
			Model model) {
		
		User user = this.userRepo.findByEmail(email);
		
		model.addAttribute("email", email);
		//model.addAttribute("password", password);
		if (user!= null
			//user.getLogin().equals(login)
				&& user.getPassword().equals(password)){
			return "home";
		}else {
			model.addAttribute("fail", true);
			return "connect";
		}
	}

}
