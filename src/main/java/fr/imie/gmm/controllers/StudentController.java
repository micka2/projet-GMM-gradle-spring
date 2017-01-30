package fr.imie.gmm.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.imie.gmm.entities.Student;
import fr.imie.gmm.entities.Subject;
import fr.imie.gmm.entities.User;
import fr.imie.gmm.repositories.StudentRepository;
import fr.imie.gmm.repositories.SubjectRepository;
import fr.imie.gmm.repositories.UserRepository;


@Controller
public class StudentController {

	List<Subject>listsujets= new ArrayList<Subject>();
	Subject sujet= new Subject(); 
	
	protected SubjectRepository subjrep;


    @Autowired
    public StudentController(SubjectRepository subjrep) {
        this.subjrep = subjrep;
    }
    

    public StudentController() {
		// TODO Auto-generated constructor stub
	}

//****************************************************************************************	
    

	@RequestMapping(method=RequestMethod.GET, path="/student")
	public String affichListSujet(
			Model model){		
		listsujets = this.subjrep.findAll();	
		
		model.addAttribute("maListeDeSujets",listsujets);
		
		return "student_view";
		
	}
	
	@RequestMapping(method=RequestMethod.POST, path="/choix")
	public String affichSujet(
			@RequestParam(name="titre_sujet")
			String titre,
			Model model){		
        
		sujet = this.subjrep.findByTitle(titre);
		
		if(sujet!=null){
		
		model.addAttribute("monSujet",sujet);
		
		return "student";
		}
		else {
			model.addAttribute("aucun sujets ne correspond à votre recherche", true);
			return "student_view";
		}
	}
	
	
	@RequestMapping("/depotDevoirs")
	public String depot(Model model){
		return "student-deposite_view";
	}
	//******************************************************************************************
//////////////recuperation des etudiants////////////////////
	
    @Autowired
    protected StudentRepository studentRepo;
    
    @CrossOrigin(origins="http://localhost:4200")
    @ResponseBody
    @RequestMapping(method=RequestMethod.GET, path="/api/1/student")
    public List studentList (Model model) {

List<Student> students = (List<Student>) this.studentRepo.findAll();
        return students;
    }

}


