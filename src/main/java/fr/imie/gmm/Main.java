package fr.imie.gmm;



import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import fr.imie.gmm.entities.User;
import fr.imie.gmm.interoperabilite.UserJsonLdap;
import fr.imie.gmm.repositories.UserRepository;

@SpringBootApplication
public class Main implements CommandLineRunner {

	
	@Autowired
	private UserRepository repository;
	private static List<User> listUser= new ArrayList<User>();
	
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		
	}

	@Override
	public void run(String...args) throws Exception {
		/*User user = new User ();
		User prof =new User();
		user.setFirstname("Administrator");
		prof.setFirstname("LUNA");
		User[] data = { prof, user };
		List<User> users=new ArrayList<User>();
	    for (User s : data){
		
		users.add(s);
	    }
		this.repository.save(users);*/
		List<UserJsonLdap> ldap=null;	
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			ldap=mapper.readValue(new File("./src/main/java/json/ldap1.json"),TypeFactory.defaultInstance().constructCollectionType(List.class,  
			UserJsonLdap.class));	
	
			System.out.println(ldap.get(0).getDisplayName());
			
			for( UserJsonLdap use :ldap )
			{
			   addUser(use,listUser);
				
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
				
		this.repository.save(listUser);
			
		
	}
	
	public static void addUser(UserJsonLdap use,List<User>users)
	{
		
		if(use.getSn()!=null)
		{
			
			User user=new User();
			user.setFirstname(use.getSn());
			user.setLastname(use.getGivenName());
			user.setLogin("log"+use.getSn());
			user.setCategoryId(1);
			user.setEmail("myEmail");
			user.setPassword("password");
			users.add(user);
			
		}
		if(!use.getSubItems().isEmpty())
		{
			for( UserJsonLdap usr :use.getSubItems() )
			{
			   addUser(usr,users);
			  			
			}
		}
			
	}
			

}	
			


