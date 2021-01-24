package tw.iii.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/register.controller").permitAll()		//.antMatchers("/").permitAll()=>代表此路徑下的網頁不需驗證     .antMatchers("/")可帶多個路徑(api)
		.antMatchers("/loginpass/**").authenticated().and().formLogin().loginPage("/login")		//.authenticated()=>存取必須通過驗證		.anyRequest()
		.defaultSuccessUrl("/loginpass/member.jsp").failureUrl("/login?error")			
		;
		
//		http.authorizeRequests().anyRequest().authenticated().and().formLogin()
//		.permitAll().and().httpBasic();
	}

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder pwdEncoder = new BCryptPasswordEncoder();		//對後續設置密碼進行加密
		auth.inMemoryAuthentication()	//存在記憶體中
		.passwordEncoder(pwdEncoder).withUser("admin").password(pwdEncoder.encode("admit123"))
		.roles("admin").and().withUser("tom").password(pwdEncoder.encode("tom123")).roles("admin");
//		PasswordEncoder pwdEncoder = new BCryptPasswordEncoder();		//對後續設置密碼進行加密
//		auth.jdbcAuthentication().dataSource(dataSource)
//		.usersByUsernameQuery("select account,password from Member where account=?")
//		.passwordEncoder(pwdEncoder).getUserDetailsService();
	}


	
	
}
