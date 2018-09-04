package domean.security.hendler;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import domean.member.dao.MemberDAO;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	MemberDAO memberDAO;
	
	private static Logger logger = Logger.getLogger(LoginSuccessHandler.class.getName());
	
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		logger.info("@ onAuthenticationSuccess - 인증성공");
		
		response.sendRedirect("member/main");
	}
}
