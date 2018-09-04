package domean.member.model;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class MemberDTO implements UserDetails 
{
	
	private static final long serialVersionUID = 1L;
	
	private String memberSeq;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberDeleteflag;
	private List<RoleDTO> memberAutority;
	


	public String getMemberDeleteflag() {
		return memberDeleteflag;
	}

	public void setMemberDeleteflag(String memberDeleteflag) {
		this.memberDeleteflag = memberDeleteflag;
	}

	public String getMemberSeq() {
		return memberSeq;
	}

	public void setMemberSeq(String memberSeq) {
		this.memberSeq = memberSeq;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public List<RoleDTO> getMemberAutority() {
		return memberAutority;
	}

	public void setMemberAutority(List<RoleDTO> memberAutority) {
		this.memberAutority = memberAutority;
	}

	@Override
	public String getPassword() {
		return memberPw;
	}

	@Override
	public String getUsername() {
		return memberId;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return memberAutority;
	}
	

    //계정이 만료 되었는가
	public boolean isAccountNonExpired() {
	        return true;
	}
	    
	//계정이 잠겨 있는가
	public boolean isAccountNonLocked() { 
	        return true;
	}
	    
	//계정의 pw가 만료되지 않았는가
	public boolean isCredentialsNonExpired() {
	        return true;
	}
	    
	//사용가능한 계정인가
	public boolean isEnabled() {
	        return true;
	}
	
}
