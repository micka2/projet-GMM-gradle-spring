package fr.imie.gmm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.imie.gmm.entities.User;


@SpringBootApplication
public class Main //implements CommandLineRunner
{

//	@Autowired

//	private UserRepository repository;

	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
		
		
//		@Override
//		public void run(String...args) throws Exception {
//			User user = new User ("toto.toto@toto.com", "pass");
//			user.setFirstname("Toto");
//			 this.repository.save(user);
//		
//			
		}


}
