package domean.member.dao;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domean.member.model.MemberDTO;
import domean.member.model.RoleDTO;

@Repository
public class MemberDAO 
{
	@Autowired
	private SqlSessionTemplate sqlSession;

	
	
	
	
	public MemberDTO selectMemberInfo(String memberId) throws SQLException {
		return sqlSession.selectOne("selectMemberBasicInfo", memberId);
	}	
	
	
	public List<RoleDTO> selectAllMemberAuthority(String memberSeq) throws SQLException{
		return sqlSession.selectList("selectAllMemberAuthority", memberSeq);
	}
	
	
	public void insertJoinMember(MemberDTO param) throws SQLException{
		sqlSession.insert("insertJoinMember", param);
	}
	
	
	public String selectOneMemberSeq(String memberId) throws SQLException{
		return sqlSession.selectOne("selectOneMemberSeq", memberId);
	}
	
	
	public void insertJoinMemberAuth(String memeberSeq) throws SQLException{
		sqlSession.insert("insertJoinMemberAuth", memeberSeq);
	}
	
}
