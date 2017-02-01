package fr.imie.gmm.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.imie.gmm.entities.Teacher;
import fr.imie.gmm.repositories.TeacherRepository;
import fr.imie.gmm.repositories.UserRepository;

@Controller
public class TeacherController {

	/**
	 * Size of a byte buffer to read/write file.
	 */
	// private static final int BUFFER_SIZE = 4096;

	/**
	 * Path of the file to be downloaded, relative to application's directory.
	 */
	// private String filePath = "./files";

	@Autowired
	protected TeacherRepository teacherRepo;

	@Autowired
	private HttpSession httpSession;

	public TeacherController() {
	}

	@RequestMapping("/teacher")
	public String teacherAccess(Model model) {
		// get connected user from session
		Teacher author = (Teacher) httpSession.getAttribute("authorSession");
		model.addAttribute("author", author);

		return "teacher_view1";
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.GET, path = "/teacher")

	@ResponseBody
	public Teacher getTeachers(Long id) {

		Teacher teacher = this.teacherRepo.findOne(id);

		return teacher;

	}

	///////// cliquer sur le bouton creer un sujet///////////

	@RequestMapping(method = RequestMethod.GET, path = "/teacher/creationdesujet")
	public String creationsubject(Model model) {
		// get connected user from session
		Teacher author = (Teacher) httpSession.getAttribute("authorSession");
		model.addAttribute("author", author);

		return "teacher_view2";
	}

	/////////////////////////////////////

	@Autowired
	protected UserRepository userRepo;

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(path = "api/1/teachers")
	@ResponseBody
	public List teacherList(Model model) {

		List<Teacher> teachers = (List<Teacher>) this.teacherRepo.findAll();
		return teachers;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.PUT, path = "/update")
	@ResponseBody
	public Teacher updateTeacher(String firstname, String lastname, Long id) {

		Teacher teacher = this.teacherRepo.findOne(id);
		teacher.setFirstname(firstname);
		teacher.setLastname(lastname);

		return teacher;

	}
}
