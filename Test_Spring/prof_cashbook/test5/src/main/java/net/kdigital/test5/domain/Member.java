package net.kdigital.test5.domain;

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
public class Member implements UserDetails{
	private static final long serialVersionUID = 1L;
	private String memberid;
	private String memberpw;
	private String membername;
	private boolean enabled;	// 계정 상태 정보 0:사용 불가능, 1: 사용가능
	private String rolename;	// 사용자 구분('ROLE_USER', 'ROLE_ADMIN')
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getPassword() {
		return this.memberpw;
	}
	
	@Override
	public String getUsername() {
		return this.memberid;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
}
