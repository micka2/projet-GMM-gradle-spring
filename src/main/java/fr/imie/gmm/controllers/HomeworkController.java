package fr.imie.gmm.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fr.imie.gmm.entities.Homework;
import fr.imie.gmm.entities.Student;
import fr.imie.gmm.repositories.HomeworkRepository;
import fr.imie.gmm.repositories.StudentRepository;

@Controller
public class HomeworkController {

	private static final String separatorNameFile = "##";

	protected HomeworkRepository homeworkRepo;

	protected Homework homeworkEntity;

	protected StudentRepository studentRepo;

	private static final String ROOTPATH = "./files";

	@Autowired
	private HttpSession httpSession;

	@Autowired
	public HomeworkController(HomeworkRepository homeworkRepository) {
		this.homeworkRepo = homeworkRepository;
	}

	@RequestMapping("/teacher/telechargerdevoirs")
	public String downlodHomework(Model model) {
		return "teacher_view3";
	}

	@RequestMapping("/studentdepot")
	public String studentDeposite(Model model) {
		// get connected user from session
		Student author = (Student) httpSession.getAttribute("authorSession");
		model.addAttribute("author", author);
		return "student-deposite_view";
	}

	/**
	 * Upload file method.
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("upload") String name, Model model,
			@RequestParam("file") MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file.

				File dir = new File(ROOTPATH + File.separator);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server.
				File serverFile = new File(dir.getAbsolutePath() + File.separator
						+ (file.getOriginalFilename() + separatorNameFile + new java.util.Date().getTime()));
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				// Get the current time.
				java.util.Date date = new java.util.Date();

				homeworkEntity = new Homework();
				homeworkEntity.setTitle(serverFile.getName());
				homeworkEntity.setDeposedAt(date);

				// get connected user from session
				Student author = (Student) httpSession.getAttribute("authorSession");

				homeworkEntity = homeworkRepo.save(homeworkEntity);

				model.addAttribute("fileName", serverFile.getName().split(separatorNameFile)[0]);
				model.addAttribute("fileId", homeworkEntity.getId());
				model.addAttribute("author", author);

				return "student-deposite_view";
			} catch (Exception e) {
				return "échec !";
			}
		} else {
			return "Impossible de déposer " + name + " car le fichier est vide ou manquant.";
		}
	}

	/**
	 * Delete file method.
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteFile(@RequestParam("delete") String fileId, Model model) {

		homeworkEntity = homeworkRepo.findOne(Long.valueOf(fileId));
		File file = new File(ROOTPATH + File.separator + homeworkEntity.getTitle());

		homeworkRepo.delete(Long.valueOf(fileId));

		// get connected user from session
		Student author = (Student) httpSession.getAttribute("authorSession");
		model.addAttribute("author", author);

		return "student-deposite_view";
	}

}
