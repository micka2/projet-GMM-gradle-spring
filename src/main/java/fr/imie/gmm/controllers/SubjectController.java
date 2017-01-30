package fr.imie.gmm.controllers;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.imie.gmm.entities.Grade;
import fr.imie.gmm.entities.Homework;
import fr.imie.gmm.entities.Student;
import fr.imie.gmm.entities.Subject;
import fr.imie.gmm.entities.Teacher;
import fr.imie.gmm.repositories.GradeRepository;
import fr.imie.gmm.repositories.SubjectRepository;
import fr.imie.gmm.repositories.TeacherRepository;

@Controller
public class SubjectController {
	
	
	protected SubjectRepository subjectRepo;
	
	protected Subject subjectEntity;
	
	@Autowired
	public SubjectController (SubjectRepository subjectRepository){
		this.subjectRepo= subjectRepository;
	}
	
	@Autowired 
	private HttpSession httpSession;
	
/////////////Récuperer les Sujets de la bd//////////////////
	
	@RequestMapping(method = RequestMethod.GET, path = "/api/1/Subject")
	public List RecupSubjects(Model model) {

		List<Subject> subjects = (List<Subject>) this.subjectRepo.findAll();
		return subjects;
	}


/////////////////Insérer un sujet en bd//////////////////////


@RequestMapping("/createSubject")
@ResponseBody
public String createSubject(String title, Date deadline,Date createAt, String description,String constraint){
 try {
	Subject subject = new Subject (title, deadline, createAt, description, constraint);
	subjectRepo.save(subject);
 }
 catch (Exception ex) {
      return "Error creating the subject: " + ex.toString();
    }
    return "Subject succesfully created!";
  }

//////////////Poster un sujet//////////////////////////


@RequestMapping(method=RequestMethod.POST, value="/createSubject")
public String createSubject(
		@RequestParam (name="title")
		String title,
		@RequestParam (name="deadline")
		Date deadline,
		@RequestParam (name="createAt")
		Date createAt,
		@RequestParam (name="description")
		String description,
		@RequestParam (name="constraint")
		String constraint,
		Model model){
	
	//get connected user from session
	Teacher author = (Teacher) httpSession.getAttribute("authorSession");
	model.addAttribute("author", author);

	Subject subject = this.subjectRepo.findByTitle(title);
	
	// Get the current time.
	java.util.Date date = new java.util.Date();
	
	subjectEntity = new Subject();
	subjectEntity.setTitle(title);
	subjectEntity.setDeadline(deadline);
	subjectEntity.setCreateAt(date);
	subjectEntity.setDescription(description);
	subjectEntity.setContsraint(constraint);
	

	subjectEntity = subjectRepo.save(subjectEntity);
 
	if ((title!= null)&&(description!=null)){
		model.addAttribute("subjectId", subjectEntity.getId());
		model.addAttribute("title", title);
		model.addAttribute("deadline", deadline);
		model.addAttribute("createat", date);
		model.addAttribute("description", description);
		model.addAttribute("constraint", constraint);
//		subjectRepo.save(subject);
      return "teacher_view1";
      
     
    }
else{
	model.addAttribute("fail2",true);
    return "teacher_view2";
    
}
		
}
}	




