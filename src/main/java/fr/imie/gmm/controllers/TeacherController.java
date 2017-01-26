package fr.imie.gmm.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.imie.gmm.entities.Grade;
import fr.imie.gmm.entities.Subject;
import fr.imie.gmm.repositories.GradeRepository;
import fr.imie.gmm.repositories.SubjectRepository;
import fr.imie.gmm.repositories.TeacherRepository;

@Controller
public class TeacherController {

	
	/**
     * Size of a byte buffer to read/write file.
     */
    private static final int BUFFER_SIZE = 4096;
             
    /**
     * Path of the file to be downloaded, relative to application's directory.
     */
   // private String filePath = "./downloads/file.zip";
    
    @Autowired
    protected TeacherRepository teacherRepo;
    
    public TeacherController() {
    }
    @RequestMapping(method=RequestMethod.GET, path="/teacher")
    public String teacherAccess (Model model){
  	  
  	  return "teacher_view1";
    }
	
//	/**
//	 * Method for handling file download request from client.
//	 */
//	@RequestMapping(method = RequestMethod.GET, path="/teacher")
//	public String downloadFile(HttpServletRequest request,
//			HttpServletResponse response)
//		throws IOException {
//
//		// get absolute path of the application
//		ServletContext context = request.getServletContext();
//		String appPath = context.getRealPath("");
//		System.out.println("appPath = " + appPath);
//
//		// construct the complete absolute path of the file
//		String fullPath = appPath + filePath;
//		File downloadFile = new File(fullPath);
//		FileInputStream inputStream = new FileInputStream(downloadFile);
//
//		// get MIME type of the file
//		String mimeType = context.getMimeType(fullPath);
//		if (mimeType == null) {
//			// set to binary type if MIME mapping not found
//			mimeType = "application/octet-stream";
//		}
//		System.out.println("MIME type: " + mimeType);
//
//		// set content attributes for the response
//		response.setContentType(mimeType);
//		response.setContentLength((int) downloadFile.length());
//
//		// set headers for the response
//		String headerKey = "Content-Disposition";
//		String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
//		response.setHeader(headerKey, headerValue);
//
//		// get output stream of the response
//		OutputStream outStream = response.getOutputStream();
//
//		byte[] buffer = new byte[BUFFER_SIZE];
//		int bytesRead = -1;
//
//		// write bytes read from the input stream into the output stream
//		while ((bytesRead = inputStream.read(buffer)) != -1) {
//			outStream.write(buffer, 0, bytesRead);
//		}
//
//		inputStream.close();
//		outStream.close();
//		
//		return "teacher_view1";
//
//	}
	/////////////////////////////////////////////////////////////////////////
	//////Recherche de promotion et affichage des sujets correspondants//////
	

	protected GradeRepository gradeRepo;
	
	@Autowired
    public TeacherController(GradeRepository gradeRepository) {
        this.gradeRepo = gradeRepository;

	/**
	 * Method for handling file download request from client.
	 */
	@RequestMapping(method = RequestMethod.GET, path="/download")
	public String downloadFile(HttpServletRequest request,
			HttpServletResponse response)
		throws IOException {

		// get absolute path of the application
		ServletContext context = request.getServletContext();
		String appPath = context.getRealPath("");
		System.out.println("appPath = " + appPath);

		// construct the complete absolute path of the file
		String fullPath = appPath + filePath;
		File downloadFile = new File(fullPath);
		FileInputStream inputStream = new FileInputStream(downloadFile);

		// get MIME type of the file
		String mimeType = context.getMimeType(fullPath);
		if (mimeType == null) {
			// set to binary type if MIME mapping not found
			mimeType = "application/octet-stream";
		}
		System.out.println("MIME type: " + mimeType);

		// set content attributes for the response
		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());

		// set headers for the response
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
		response.setHeader(headerKey, headerValue);

		// get output stream of the response
		OutputStream outStream = response.getOutputStream();

		byte[] buffer = new byte[BUFFER_SIZE];
		int bytesRead = -1;

		// write bytes read from the input stream into the output stream
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}

		inputStream.close();
		outStream.close();
		
		return "teacher_view";

	}
	
	@RequestMapping(method=RequestMethod.GET, path="/recherchepromotion")
	public String checkGrade (
			@RequestParam(name="Name")
			String Name,
			Model model){
		
		Grade gradeRepo = new Grade(Name);
		Grade grade = this.gradeRepo.findByName(Name);
		
		if(grade==null){
			return ("teacher_view1");
		}
		else if ((grade!=null)&&(grade.getName().equals(Name))){
			model.addAttribute("NamePromo", grade);
		return ("teacher_view1");
	}
		else{
			model.addAttribute("fail", true);
			return "teacher_view1";
	}		
	
	}
	
	
	
		////////////////////////////////////////////////
		///////creer un nouveau sujet//////////////////
	@Autowired
	protected SubjectRepository subjectRepo;
	
	@RequestMapping("/createSubject")
	@ResponseBody
	public String createSubject(String title, Date deadline, String description, String constraint){
	 try {
		Subject subject = new Subject (title, deadline, description, constraint);
		subjectRepo.save(subject);
	 }
	 catch (Exception ex) {
	      return "Error creating the subject: " + ex.toString();
	    }
	    return "Subject succesfully created!";
	  }
		

	}


