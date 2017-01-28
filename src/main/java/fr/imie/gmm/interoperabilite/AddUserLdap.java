/*package fr.imie.gmm.interoperabilite;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import fr.imie.gmm.entities.User;


public class AddUserLdap {
	
	private static List<User> listUser= new ArrayList<User>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
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
				
		System.out.println(listUser);
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

}*/
