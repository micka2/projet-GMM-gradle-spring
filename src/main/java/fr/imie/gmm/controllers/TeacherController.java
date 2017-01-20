package fr.imie.gmm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TeacherController {

	
	@RequestMapping(method=RequestMethod.GET, path="/teacher")
    public String Teacher(Model model) {
        return "teacher_view";
    }
}
