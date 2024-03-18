package net.kdigital.test5.security;

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
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/", "/member/signup",
					 "/images/**", "/style/**", "/script/**").permitAll()
					 // 위에 설정한 모든 접근은 인증절차 없이 허용
		.anyRequest().authenticated() // 위의 경로 외에는 모두 로그인을 해야함
		.and()
		.formLogin() 				  // 일반적인 폼을 이용한 로그인 처리/실패를 이용
		.loginPage("/member/signin")
		.loginProcessingUrl("/member/signin").permitAll() // 인증처리를 하는 URL 생성. 로그인 폼의 action
		.usernameParameter("memberid")
		.passwordParameter("memberpw")
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
				"SELECT memberid username, memberpw password, enabled "
				+ "FROM cashbook_member WHERE memberid=?")
		// 권한
		.authoritiesByUsernameQuery(
				"SELECT memberid username, rolename role_name "
				+ "FROM cashbook_member WHERE memberid=?");
	}
	
	// 단방향 암호화 (역으로 풀어낼 수 없다)
	@Bean // Bean : SpringFramework가 관리하는 모든 객체
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	
}
