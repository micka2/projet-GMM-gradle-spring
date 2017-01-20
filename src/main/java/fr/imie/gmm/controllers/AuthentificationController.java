package fr.imie.gmm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.imie.gmm.entities.User;
import fr.imie.gmm.repositories.UserRepository;



@Controller
public class AuthentificationController {

	/*private static final String admin_username="admin";
	private static final String admin_password="mypass";
	private static final String teach_username="teach";
	private static final String teach_password="tpass";
	private static final String stud_username="stud";
	private static final String stud_password="stpass";*/
	
	protected UserRepository userRepo;
	
//******************* constructor ****************************************
	public AuthentificationController(){
		
	}
	
    @Autowired
    public AuthentificationController(UserRepository userRepository) {
        this.userRepo = userRepository;
    }
    
//**************************************************************************    

  @RequestMapping(method=RequestMethod.GET, path="/login")
  public String login(
          Model model) {
      return "authentification_view";
  }

  @RequestMapping(method=RequestMethod.POST, path="/loginCheck")
  public String loginCheck(
          @RequestParam(name="view_username")
          String username,
          @RequestParam(name="view_password")
          String password,
          Model model) {
	  User user = this.userRepo.findByEmail(username);
	  
	  /*(admin_username.equals(username))&&(admin_password.equals(password))*/
	  if((user!=null)&&(user.getPassword().equals(password))&&(user.getCategoryId()==3)){
			
			model.addAttribute(username);
			model.addAttribute(password);
			return "administator_view";
		}
	  else if((user!=null)&&(user.getPassword().equals(password))&&(user.getCategoryId()==1)){
		  
		  model.addAttribute(username);
		  model.addAttribute(password);
		  return "teacher_view";
	  }
	  else if((user!=null)&&(user.getPassword().equals(password))&&(user.getCategoryId()==2)){
		  
		  model.addAttribute(username);
		  model.addAttribute(password);
		  return "student_view";
	  }
		else{
			model.addAttribute("fail", true);
			return "authentification_view";
		}
  
  }

  @RequestMapping(method=RequestMethod.GET, path="/logout")
  public String logout(
          Model model) {
      return "auth_view";
  }

  @RequestMapping(method=RequestMethod.GET, path="/reset")
  public String resetPassword(
          Model model) {
      return null;
  }
  
  @RequestMapping(method=RequestMethod.GET, path="/archive")
  public String archiveAccess(Model model){
	  
	  
	  return "archive_view";
  }

}
