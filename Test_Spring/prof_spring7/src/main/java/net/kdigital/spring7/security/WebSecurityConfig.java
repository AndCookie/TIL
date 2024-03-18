package net.kdigital.spring7.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/",
				"/board/listboard",
				"/board/readboard",
				"/member/signup",
				"/images/**",
				"/css/**",
				"/script/**").permitAll()    	// 위에서 설정한 접근은 인증절차없이 허용
		.anyRequest().authenticated()			// 위의 경로 외에는 모두 로그인을 해야함
		.and()
		.formLogin()							// 일반적인 폼을 이용한 로그인 처리/실패을 이용
		.loginPage("/member/signin").permitAll() // 인증처리를 하는 URL 설정. 로그인 폼의 action
		.usernameParameter("memberid")
		.passwordParameter("memberpwd")
		.and()
		.logout()
		.logoutSuccessUrl("/").permitAll()
		.and()
		.cors()
		.and()
		.httpBasic();
		
		return http.build();
	}
	
	// 인증을 위한 쿼리
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		// 인증(로그인)
		.usersByUsernameQuery(
			"SELECT memberid username, memberpwd password, enabled "
			+ "FROM members WHERE memberid = ?")
		// 권한
		.authoritiesByUsernameQuery(
			"SELECT memberid username, rolename role_name "
			+ "FROM members WHERE memberid = ?");
	}
	
	// 단방향 암호화
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}








