package net.kdigital.todolist.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Person implements UserDetails{
	private String todoid;
	private String todopwd;
	private String todoname;
	private boolean enabled;
	private String rolename;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getPassword() {
		return this.todoid;
	}
	@Override
	public String getUsername() {
		return this.todopwd;
	}
	@Override
	public boolean isAccountNonExpired() {
		// 휴면 계정
		return false;
	}
	@Override
	public boolean isAccountNonLocked() {
		// 이중 로그인
		return false;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// 비밀번호 휴면
		return false;
	}

}

