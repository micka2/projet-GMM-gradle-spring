package fr.imie.gmm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.imie.gmm.entities.Teacher;
import fr.imie.gmm.entities.User;
import fr.imie.gmm.repositories.TeacherRepository;
import fr.imie.gmm.repositories.UserRepository;

@Controller
public class AngularControllerTestAPI {

	//protected UserRepository userRepo;
	protected TeacherRepository teacherRepo;
	
	//******************************************************************
	@Autowired
    public AngularControllerTestAPI(TeacherRepository teacherRepository) {
        
        this.teacherRepo= teacherRepository;
    }
	
	public AngularControllerTestAPI(){
		
	}
	//**********************************************************************
	@CrossOrigin(origins="http://localhost:4200")
	@RequestMapping(method=RequestMethod.GET, path="/api/1/teachers")
	@ResponseBody
    public List<Teacher> TestAngular(Model model) {
		
		List<Teacher> teachs = (List<Teacher>) this.teacherRepo.findAll();
		
        return teachs;
    }
}
