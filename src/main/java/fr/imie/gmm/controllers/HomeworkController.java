package fr.imie.gmm.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeworkController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeworkController.class);

	/**
	 * Upload file method.
	 */
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String uploadFile(@RequestParam("nom") String name, Model model,
			@RequestParam("fichier") MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file.
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server.
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				
				logger.info("Chemin d'accès du fichier="
						+ serverFile.getAbsolutePath());
				
				// Get the current time.
				java.util.Date date = new java.util.Date();
				
				model.addAttribute("fileName", name);
				model.addAttribute("createAt", date);

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
