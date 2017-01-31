package fr.imie.gmm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.imie.gmm.entities.Teacher;
import fr.imie.gmm.entities.User;
import fr.imie.gmm.repositories.TeacherRepository;
import fr.imie.gmm.repositories.UserRepository;

@Controller
public class TeacherController {

	
	/**
     * Size of a byte buffer to read/write file.
     */
  //  private static final int BUFFER_SIZE = 4096;
             
    /**
     * Path of the file to be downloaded, relative to application's directory.
     */
   // private String filePath = "./downloads/file.zip";
    
    @Autowired
    protected TeacherRepository teacherRepo;
    
    public TeacherController() {
    }
    @CrossOrigin(origins="http://localhost:4200")
    @RequestMapping(method=RequestMethod.GET, path="/teacher")
   
    @ResponseBody
    public Teacher getTeachers (Long id){
    							
    	Teacher teacher = this.teacherRepo.findOne(id);
  	 
  	  return teacher;

    }
  
   
    
    /////////cliquer sur le bouton creer un sujet///////////
    
    @RequestMapping(method=RequestMethod.GET, path="/teacher/creationdesujet")
    public String creationsubject (Model model){
  	  
  	  return "teacher_view2";
    }
    

	
    /////////////////////////////////////

    
 
    
    @CrossOrigin(origins="http://localhost:4200")
    @RequestMapping(path="api/1/teachers")
    @ResponseBody
    public List teacherList (Model model) {

List<Teacher> teachers = (List<Teacher>) this.teacherRepo.findAll();
        return teachers;
    }
    
    
    


	/////////////////////////////////////////////////////////////////////////
	//////Recherche de promotion et affichage des sujets correspondants//////
	

//	/**
//	 * Method for handling file download request from client.
//	 */
//	@RequestMapping(method = RequestMethod.GET, path="/download")
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
	
	

	
	
///////////////////////clique sur le bouton modifier/////////////////
	
//	
//	@RequestMapping(method=RequestMethod.POST, path="teacher/affichersujet")
//		public String recupsujet( 
//				@RequestParam (name="title")
//				String title,
//				Model model){
//		Subject subject = this.subjectRepo.findByTitle(title);
//	if ((subject!= null)){
//		return "teacher_view2";
//	}else{
//		model.addAttribute("fail", true);
//		return "teacher_view1";
//	}
//}
//	
//	@RequestMapping(method=RequestMethod.GET, path="/teacher/modificationsujet")
//		public String sendmodifpage (
//				Model model){
//		return "teacher_view2";
//	}
//	
//////////////////////////poster un nouveau sujet////////////////////
	
	
//	@RequestMapping(method=RequestMethod.GET, path="/recherchepromotion")
//	public String checkGrade (
//			@RequestParam(name="Name")
//			String Name,
//			Model model){
//		
//		Grade gradeRepo = new Grade(Name);
//		Grade grade = this.gradeRepo.findByName(Name);
//		
//	
//		if ((grade!=null)&&(grade.getName().equals(Name))){
//			model.addAttribute("NamePromo", grade);
//		return ("teacher_view1");
//	}
//		else{
//			model.addAttribute("fail", true);
//			return "teacher_view1";
//	}		
//	
//	}

///////////////////////////////////////////////////////////////////
  
    
    
    @CrossOrigin(origins="http://localhost:4200")
    @RequestMapping(method=RequestMethod.PUT, path="/update")
    @ResponseBody
    public Teacher updateTeacher (String firstname, String lastname, Long id){
    							
    	Teacher teacher = this.teacherRepo.findOne(id);
    	teacher.setFirstname(firstname);
    	teacher.setLastname(lastname);
  	 
  	  return teacher;

    }
}


