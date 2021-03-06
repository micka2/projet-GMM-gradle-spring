package fr.imie.gmm.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable();

		httpSecurity.anonymous().and().authorizeRequests().antMatchers("/create").permitAll().antMatchers("/login/**")
				.permitAll().antMatchers("/createSubject").permitAll().antMatchers("/api/**").permitAll()
				.antMatchers("/teacher").permitAll().antMatchers("/update").permitAll().antMatchers(HttpMethod.OPTIONS)
				.permitAll()

		;
	}

}
