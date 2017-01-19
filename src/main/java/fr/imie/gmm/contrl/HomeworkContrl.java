package fr.imie.gmm.contrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeworkContrl {
	
	@RequestMapping(method=RequestMethod.GET, path="/homework")
    public String Homework(Model model) {
        return "student-deposite_view";

}
	
}
