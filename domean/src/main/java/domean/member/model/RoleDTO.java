package domean.member.model;


import org.springframework.security.core.GrantedAuthority;

public class RoleDTO implements GrantedAuthority{
	private static final long serialVersionUID = 1L; 
	
	
	
	
	private String memberAuthority; 

	
	

	public String getMemberAuthority() {
		return memberAuthority;
	}




	public void setMemberAuthority(String memberAuthority) {
		this.memberAuthority = memberAuthority;
	}




	@Override 
	public String getAuthority() { 
		return memberAuthority; 
	}
	
}
