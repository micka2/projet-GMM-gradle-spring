package fr.imie.gmm.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.imie.gmm.entities.Teacher;
import fr.imie.gmm.repositories.ArchiveRepository;
import fr.imie.gmm.repositories.HomeworkRepository;

@Controller
public class ArchiveController {

	
	@Autowired
	public ArchiveController(ArchiveRepository archiveRepository) {
        this.archiveRepo = archiveRepository;
	}
	
    protected ArchiveRepository archiveRepo;
	
	
	@Autowired 
	private HttpSession httpSession;
	
	public ArchiveController() {
    }

	
	@RequestMapping(method=RequestMethod.GET, path="/archives")
	public String archives (Model model){
		Teacher author = (Teacher) httpSession.getAttribute("authorSession");
		model.addAttribute("author", author);
		
		return "archive_view";
	}	
	
}
