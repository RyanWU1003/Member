package tw.iii.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
	      .antMatchers("/login").permitAll()
	      .antMatchers("/css/**").permitAll()
	      .antMatchers("/register.jsp").permitAll()
	      .antMatchers("/register.controller").permitAll()
	      .antMatchers("/home").hasAnyRole("ADMIN")
			.anyRequest().authenticated()
			.and()
			
		.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/perform_login")
			.defaultSuccessUrl("/home", true)
			.failureUrl("/login?error=true")
			.and()
		.logout()
			.logoutUrl("/perform_logout")
			.logoutSuccessUrl("/login");
		
//		http.authorizeRequests().anyRequest().authenticated().and().formLogin()
//		.permitAll().and().httpBasic();
	}

	@Bean
	public PasswordEncoder passwordEncoder() { 
	    return new BCryptPasswordEncoder(); 
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.passwordEncoder(passwordEncoder())
		.withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")
		.and()
		.withUser("tom").password(passwordEncoder().encode("tom123")).roles("USER");
//		userDetailsService()//要實做這個
//		PasswordEncoder pwdEncoder = new BCryptPasswordEncoder();		//對後續設置密碼進行加密
//		auth.jdbcAuthentication().dataSource(dataSource)
//		.usersByUsernameQuery("select account,password from Member where account=?")
//		.passwordEncoder(pwdEncoder).getUserDetailsService();
	}


	
	
}
