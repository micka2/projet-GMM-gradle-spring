package fr.imie.gmm.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.imie.gmm.entities.Student;
import fr.imie.gmm.entities.Teacher;
import fr.imie.gmm.entities.User;
import fr.imie.gmm.repositories.GradeRepository;
import fr.imie.gmm.repositories.TeacherRepository;
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
	
	protected GradeRepository gradeRepo;
		
	@Autowired 
	private HttpSession httpSession;
	
	private static final Logger logger = LoggerFactory.getLogger(AuthentificationController.class);
	
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
      return "connection_view";
  }


  @RequestMapping(method=RequestMethod.POST, path="/checklogin")
  public String loginCheck(
		  
          @RequestParam(name="login")
          String login,
          @RequestParam(name="password")
          String password,
          Model model) {

	 User user = this.userRepo.findByLogin(login);


	  /*(admin_username.equals(username))&&(admin_password.equals(password))*/
	  if((user!=null)&&(user.getPassword().equals(password))&&(user.getCategoryId()==3)){
			
			model.addAttribute("login", login);
			//model.addAttribute(password);
			return "admin_view";
		}
	  else if((user!=null)&&(user.getPassword().equals(password))&&(user.getCategoryId()==1)){
		  
		  model.addAttribute("login", login);
		 // model.addAttribute(password);
		  return "teacher_view1";
	  }
	  else if((user!=null)&&(user.getPassword().equals(password))&&(user.getCategoryId()==2)){		  
		  model.addAttribute("login", login);
		  //model.addAttribute(password);
		  Student connectedUser =  new Student(user);
		  
		  model.addAttribute("author", connectedUser);
		  // session mappage
		  this.httpSession.setAttribute("authorSession", connectedUser);
		  return "student_view";
	  }
		else{
			model.addAttribute("fail", true);
			return "connection_view";
		}
  
  }

  @RequestMapping(method=RequestMethod.GET, path="/logout")
  public String logout(
          Model model) {
      return "connection_view";
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
  
  ///////////////////////////////////////////////////////
  
  @Autowired
	protected TeacherRepository teacherRepo;
	
	@RequestMapping("/createTeacher")
	@ResponseBody
	public String createTeacher(String firstname,String lastname, String login, String password, String email, int categoryId){
	 try {
		Teacher teacher = new Teacher (firstname, lastname, login, password, email, 1);
		teacherRepo.save(teacher);
	 }
	 catch (Exception ex) {
	      return "Error creating the teacher: " + ex.toString();
	    }
	    return "Teacher succesfully created!";
	  }
}	

