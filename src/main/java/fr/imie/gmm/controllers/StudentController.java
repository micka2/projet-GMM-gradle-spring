package fr.imie.gmm.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.imie.gmm.entities.Subject;
import fr.imie.gmm.repositories.SubjectRepository;


@Controller
public class StudentController {

	List<Subject>listsujets= new ArrayList<Subject>();
	Subject sujet= new Subject(); 
	protected SubjectRepository subjrep;


    @Autowired
    public StudentController(SubjectRepository subjrep) {
        this.subjrep = subjrep;
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
		
		return "student_view";
		}
		else {
			model.addAttribute("aucun sujets ne correspond à votre recherche", true);
			return "student_view";
		}
	}
	
	
	@RequestMapping("/depotDevoirs")
	public String depot(Model model){
		return "depotDevoirs_view";
	}
	//******************************************************************************************
}
