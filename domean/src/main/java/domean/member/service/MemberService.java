package domean.member.service;

import java.sql.SQLException;


import domean.member.model.MemberDTO;

public interface MemberService {

	public void insertJoinMember(MemberDTO memberInfo) throws SQLException;
	
	public MemberDTO selectOneMemeberInfo(String memberId) throws SQLException;
	
	
	
}
