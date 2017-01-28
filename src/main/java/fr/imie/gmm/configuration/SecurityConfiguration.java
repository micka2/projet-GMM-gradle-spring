package fr.imie.gmm.configuration;



import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure (HttpSecurity httpSecurity) throws Exception{ 
		httpSecurity.csrf().disable();
		
		httpSecurity
		.anonymous().and()
		.authorizeRequests()
		.antMatchers ("/create").permitAll()
		//.antMatchers("/**").authenticated()
		.antMatchers ("/login/**").permitAll()
		.antMatchers ("/createSubject").permitAll()
		.antMatchers ("/teacher").permitAll()
		.antMatchers("/api/**").permitAll()
		;
	}

}
	
