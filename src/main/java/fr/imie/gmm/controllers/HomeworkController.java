package fr.imie.gmm.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.metadata.GenericTableMetaDataProvider;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import fr.imie.gmm.entities.Homework;
import fr.imie.gmm.entities.Student;
import fr.imie.gmm.entities.Subject;
import fr.imie.gmm.repositories.HomeworkRepository;


@Controller
public class HomeworkController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeworkController.class);
	
	private static final String separatorNameFile = "##";
	
	protected HomeworkRepository homeworkRepo;
	
	protected Homework homeworkEntity;
	
	@Autowired
    public HomeworkController(HomeworkRepository homeworkRepository) {
        this.homeworkRepo = homeworkRepository;
    }

	
	@RequestMapping("/studentdepot")
	public String studentDeposite(Model model){
		
		return "student-deposite_view";
	}
	
	/**
	 * Upload file method.
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("upload") 
							String name,
							Model model,
							@RequestParam("file") 
							MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file.
				String rootPath = "./files";
				File dir = new File(rootPath + File.separator);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server.
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + ( file.getOriginalFilename() + separatorNameFile + new java.util.Date().getTime()) );
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				
//				Homework homework = this.homeworkRepo.save(serverFile);
				
				logger.info("Chemin d'accès du fichier="
						+ serverFile.getAbsolutePath().split(separatorNameFile)[0]);
				
				// Get the current time.
				java.util.Date date = new java.util.Date();
				
				model.addAttribute("fileName", serverFile.getName().split(separatorNameFile)[0]);
				
				homeworkEntity = new Homework();
				homeworkEntity.setTitle(serverFile.getName());
				homeworkEntity.setDeposedAt(date);
				
				logger.info(homeworkEntity.toString());
				
				homeworkEntity = homeworkRepo.save(homeworkEntity);
								
				return "student-deposite_view";
			} catch (Exception e) {
				return "échec !";
			}
		} else {
			return "Impossible de déposer " + name
					+ " car le fichier est vide ou manquant.";
		}
	}
}
