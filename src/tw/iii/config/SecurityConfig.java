package tw.iii.config;

import org.springframework.context.annotation.Configuration;
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
		http.authorizeRequests().anyRequest().authenticated().and().formLogin()
		.permitAll().and().httpBasic();
	}

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder pwdEncoder = new BCryptPasswordEncoder();		//對後續設置密碼進行加密
		auth.inMemoryAuthentication()	//存在記憶體中
		.passwordEncoder(pwdEncoder).withUser("admin").password(pwdEncoder.encode("admit123"))
		.roles("admin").and().withUser("tom").password(pwdEncoder.encode("tom123")).roles("admin");
//		PasswordEncoder pwdEncoder = new BCryptPasswordEncoder();		//對後續設置密碼進行加密
//		auth.jdbcAuthentication().dataSource(dataSource).
	}


	
	
}
