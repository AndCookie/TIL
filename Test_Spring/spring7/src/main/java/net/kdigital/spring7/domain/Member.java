package net.kdigital.spring7.domain;

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
	private String memberid;
	private String memberpwd;
	private String membername;
	private String email;
	private String phone;
	private String address;
	private boolean enabled;	// 계정의 상태 정보 (0:사용불가 / 1:사용가능)
	private String rolename;	// 사용자 구분 ('ROLE_USER' 일반 사용자, 'ROLE ADMIN' 관리자)
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPassword() {
		return this.memberpwd;
	}
	@Override
	public String getUsername() {
		return this.memberid;
	}
	@Override
	public boolean isAccountNonExpired() {
		// 휴면 계정
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// 이중 로그인
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// 비밀번호 휴면
		return true;
	}
}
