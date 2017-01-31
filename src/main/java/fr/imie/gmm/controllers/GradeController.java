package fr.imie.gmm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.imie.gmm.entities.Grade;
import fr.imie.gmm.repositories.GradeRepository;

@Controller
public class GradeController {

	protected GradeRepository gradeRepo;
	
	@Autowired
	public GradeController (GradeRepository gradeRepository){
		this.gradeRepo= gradeRepository;
	}
	
	
/////////////Récuperer les promotions//////////////////
	
	@RequestMapping (method=RequestMethod.GET, path="/api/1/Grade")
    public List recupGrade(Model model) {

List<Grade> grades = (List<Grade>) this.gradeRepo.findAll();
        return grades;
    }
	
	
/////////////////Insérer une promotion//////////////////////
	
	 
		
		@RequestMapping("/createGrade")
		@ResponseBody
		public String createGrade(String name,Integer year){
		 try {
			Grade grade = new Grade (name, year);
			gradeRepo.save(grade);
		 }
		 catch (Exception ex) {
		      return "Error creating the grade: " + ex.toString();
		    }
		    return "Grade succesfully created!";
		  }
	}	

	
	

