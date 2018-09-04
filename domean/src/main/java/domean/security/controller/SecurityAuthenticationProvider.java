package domean.security.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;

import domean.member.model.MemberDTO;
import domean.security.service.SecurityUserDetailsService;

public class SecurityAuthenticationProvider implements AuthenticationProvider {
	
	private static Logger logger = Logger.getLogger(SecurityAuthenticationProvider.class.getName());
	
	@Autowired
	SecurityUserDetailsService suds;

	@Autowired
	private PasswordEncoder passwordEncoder;

	
	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		logger.info("@ authenticate");

		String memberId = authentication.getName();
		String memberPw = (String) authentication.getCredentials();

		MemberDTO memberInfo = suds.loadUserByUsername(memberId);

		if (!passwordEncoder.matches(memberPw, memberInfo.getMemberPw())) {
			throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
		}

		return new UsernamePasswordAuthenticationToken(memberInfo, memberPw, memberInfo.getMemberAutority());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
