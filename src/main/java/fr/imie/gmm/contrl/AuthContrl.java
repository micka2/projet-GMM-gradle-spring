package fr.imie.gmm.contrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthContrl {

	private static final String admin_username="admin";
	private static final String admin_password="mypass";
	private static final String teach_username="teach";
	private static final String teach_password="tpass";
	private static final String stud_username="stud";
	private static final String stud_password="stpass";


  @RequestMapping(method=RequestMethod.GET, path="/login")
  public String login(
          Model model) {
      return "auth_view";
  }

  @RequestMapping(method=RequestMethod.POST, path="/loginCheck")
  public String loginCheck(
          @RequestParam(name="view_username")
          String username,
          @RequestParam(name="view_password")
          String password,
          Model model) {

	  if((admin_username.equals(username))&&(admin_password.equals(password))){
			
			model.addAttribute(username);
			model.addAttribute(password);
			return "admin_view";
		}
	  else if((teach_username.equals(username))&&(teach_password.equals(password))){
		  
		  model.addAttribute(username);
		  model.addAttribute(password);
		  return "teacher_view";
	  }
	  else if((stud_username.equals(username))&&(stud_password.equals(password))){
		  
		  model.addAttribute(username);
		  model.addAttribute(password);
		  return "student_view";
	  }
		else{
			model.addAttribute("fail", true);
			return "auth_view";
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

}
