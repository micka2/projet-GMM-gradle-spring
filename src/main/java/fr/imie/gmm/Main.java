package fr.imie.gmm;

<<<<<<< HEAD

import org.springframework.beans.factory.annotation.Autowired;
=======
>>>>>>> micka
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Main implements CommandLineRunner {



	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
		
<<<<<<< HEAD


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	/*@Override
	public void run(String...args) throws Exception {
			User user = new User ("toto.toto@toto.com", "pass");
		user.setFirstname("Toto");
			 this.repository.save(user);
			 }*/
=======
	}
	
	
		@Override
		public void run(String...args) throws Exception {
			
		}
>>>>>>> micka


}
