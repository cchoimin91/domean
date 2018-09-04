package domean.member.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domean.member.dao.MemberDAO;
import domean.member.model.MemberDTO;
import domean.member.model.RoleDTO;

@Service("MemberServiceImple")
public class MemberServiceImple implements MemberService{

	
	@Autowired
	private MemberDAO memberDAO;

	
	
	
	
	@Transactional(rollbackFor =Exception.class) 
	@Override
	public void insertJoinMember(MemberDTO memberInfo) throws SQLException {
		memberDAO.insertJoinMember(memberInfo);
		String memberSeq;
		memberSeq = memberDAO.selectOneMemberSeq(memberInfo.getMemberId());
		memberDAO.insertJoinMemberAuth(memberSeq);
	}


	@Override
	public MemberDTO selectOneMemeberInfo(String memberId) throws SQLException {
		
		MemberDTO memberDTO = memberDAO.selectMemberInfo(memberId);
		
		if (memberDTO != null) {
			List<RoleDTO> rols = memberDAO.selectAllMemberAuthority(memberDTO.getMemberSeq());
			memberDTO.setMemberAutority(rols);
		}
		
		return memberDTO;
	}

}
