package fr.imie.gmm.contrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudContrl {

	@RequestMapping(method=RequestMethod.GET, path="/student")
    public String Student(Model model) {
        return "student_view";
    }
}
