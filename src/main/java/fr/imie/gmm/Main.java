package fr.imie.gmm;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.imie.gmm.entities.Student;
import fr.imie.gmm.entities.Teacher;
import fr.imie.gmm.entities.User;
import fr.imie.gmm.interoperabilite.InGradeJson;
import fr.imie.gmm.interoperabilite.StudentJsonLdap;
import fr.imie.gmm.interoperabilite.TeacherJsonLdap;
import fr.imie.gmm.repositories.StudentRepository;
import fr.imie.gmm.repositories.TeacherRepository;
import fr.imie.gmm.repositories.UserRepository;




@SpringBootApplication
public class Main implements CommandLineRunner {

	
	@Autowired
	private UserRepository repository;
	@Autowired
	private StudentRepository srepo;
	@Autowired
	private TeacherRepository trepo;
	
	private static List<User> listUser1= new ArrayList<User>();
	private static List<User> listUser2= new ArrayList<User>();
	private static List<Teacher> listTeacher= new ArrayList<Teacher>();
	private static List<Student> listStudent= new ArrayList<Student>();
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		
	}

	@Override
	public void run(String...args) throws Exception {
		
		List<TeacherJsonLdap> ldap=null;
		List<StudentJsonLdap> ldap2=null;
		InGradeJson ldapGrade=new InGradeJson();
		ObjectMapper mapper1 = new ObjectMapper();
		ObjectMapper mapper2 = new ObjectMapper();
		
		try {
			ldap=mapper1.readValue(new File("./src/main/java/json/resultats_ldap_teachers.json"),TypeFactory.defaultInstance().constructCollectionType(List.class,  
			TeacherJsonLdap.class));	
			ldap2=mapper2.readValue(new File("./src/main/java/json/resultats_ldap_students.json"),TypeFactory.defaultInstance().constructCollectionType(List.class,  
					StudentJsonLdap.class));
			
			System.out.println(ldap.get(0).getLastName());
			System.out.println(ldap2.get(0).getLastName());
			
			for( StudentJsonLdap use :ldap2 )
			{
			   addStudent(ldapGrade,use,listUser2,listStudent);
		
			}
			
			for( TeacherJsonLdap use :ldap )
			{
			   addTeacher(use,listTeacher,listUser1);
				
			}
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//this.repository.save(listTeacher);
		
		//this.repository.save(listStudent);
	}
	
	
	public static void addTeacher(TeacherJsonLdap use,List<Teacher>teachers,List<User>users)
	{
		User user=new User();
		Teacher teach=new Teacher();
		if(use.getFirstName()!=null)
		{	
			teach.setFirstname(use.getLastName());
			user.setFirstname(use.getLastName());
			teach.setLastname(use.getFirstName());
			user.setLastname(use.getFirstName());
			teach.setLogin(use.getFirstName()+use.getLastName());
			user.setLogin(use.getFirstName()+use.getLastName());
			teach.setCategoryId(1);
			user.setCategoryId(1);
			teach.setEmail(use.getFirstName()+"."+use.getLastName()+"@imie.fr");
			user.setEmail(use.getFirstName()+"."+use.getLastName()+"@imie.fr");
			teach.setPassword(use.getPassword());
			user.setPassword(use.getPassword());
			teachers.add(teach);			
			users.add(user);
		}
			
	}
	
	public static void addStudent(InGradeJson grade,StudentJsonLdap use,List<User>users,List<Student>students)
	{
		User user=new User();
		Student stud=new Student();
		if(use.getFirstName()!=null)
		{		
			stud.setFirstname(use.getLastName());
			user.setFirstname(use.getLastName());
			stud.setLastname(use.getFirstName());
			user.setLastname(use.getFirstName());
			stud.setLogin(use.getFirstName()+use.getLastName());
			user.setLogin(use.getFirstName()+use.getLastName());
			stud.setCategoryId(2);
			user.setCategoryId(2);
			stud.setEmail(use.getFirstName()+"."+use.getLastName()+"@imie.fr");
			user.setEmail(use.getFirstName()+"."+use.getLastName()+"@imie.fr");
			stud.setPassword(use.getPassword());
			user.setPassword(use.getPassword());
			students.add(stud);			
			users.add(user);
			
		}
		/*if(use.getInGrade()!=null)
		{
			stud.setGradeId(grade.getCreatAt());
			
			//Le type de gradeId me pose un probleme car c'est un type Objet,pour charger automatiquement
			 // à part ça c'est ok.
		}*/
			
	}
			

}	
			


