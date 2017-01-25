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
		.antMatchers ("/login").permitAll()
		.antMatchers ("/checklogin").permitAll()
		.antMatchers ("/reset").permitAll()
		.antMatchers ("/logout").permitAll()
		.antMatchers ("/archive").permitAll()
		.antMatchers ("/student").permitAll()
		.antMatchers ("/teacher").permitAll()
		.antMatchers ("/choix").permitAll()
		.antMatchers ("/").permitAll()
//		.antMatchers("/**").authenticated()
		;
	}
	
//	@Override
//	protected void configure(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.csrf().disable();
//
//		/*httpSecurity.anonymous().and().authorizeRequests().antMatchers("/**")
//				.permitAll().antMatchers("/**").authenticated();*/
//
////		httpSecurity.authorizeRequests()
////	    	.antMatchers("/", "/teacher/**", "/teacherfile/**").permitAll()
////	    	.anyRequest().authenticated();
//		//.antMatchers("/teacher/**").access("hasRole('ROLE_ADMIN')")
//
//		httpSecurity
//				.authorizeRequests()
//				.anyRequest()
//				.authenticated()
//			.and()
//				.formLogin()
//					.loginPage("/login")
//					.permitAll()
//			.and()
//        		.httpBasic();
//	}
}
	
