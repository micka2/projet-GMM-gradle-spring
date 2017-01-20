package fr.imie.gmm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fr.imie.gmm.entities.User;
import fr.imie.gmm.repositories.UserRepository;

@SpringBootApplication
public class Main //implements CommandLineRunner
{

//	@Autowired
//	private UserRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		
//		
//		@Override
//		public void run(String...args) throws Exception {
//			User user = new User ("toto.toto@toto.com", "pass");
//			user.setFirstname("Toto");
//			 this.repository.save(user);
//		
//			
//		}

	}

}
