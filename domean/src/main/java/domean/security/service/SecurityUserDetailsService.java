package domean.security.service;

import java.sql.SQLException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import domean.member.dao.MemberDAO;
import domean.member.model.MemberDTO;
import domean.member.service.MemberService;

@Service("SecurityUserDetailsService")
public class SecurityUserDetailsService implements UserDetailsService {
	
	private static Logger logger = Logger.getLogger(SecurityUserDetailsService.class.getName());
	
	@Autowired
	private MemberService memberService;
	
	
	@Override
	public MemberDTO loadUserByUsername(String memberId) throws UsernameNotFoundException {

		logger.info("@ loadUserByUsername");
		
		MemberDTO memberDTO = new MemberDTO();
		try {
			memberDTO = memberService.selectOneMemeberInfo(memberId);
		} catch (SQLException e) {
			logger.severe(e.getMessage());
		}

		if (memberDTO == null)
			throw new UsernameNotFoundException("접속자 정보를 찾을 수 없습니다.");

		return memberDTO;
	}
}// END
