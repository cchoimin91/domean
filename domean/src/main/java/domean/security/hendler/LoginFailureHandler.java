package domean.security.hendler;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class LoginFailureHandler implements AuthenticationFailureHandler {
	
	private static Logger logger = Logger.getLogger(LoginFailureHandler.class.getName());
	
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException auth) throws IOException, ServletException {
		
		logger.info("@ onAuthenticationFailure - 인증실패");

		String defaultFailURL = null;
		String mobileYN = request.getParameter("M");

		String loginFailMassage = "ID와 PW를 확인 해 주세요";
		String member_id = request.getParameter("member_id");

		if (StringUtils.isBlank(mobileYN)) {
			defaultFailURL = "/index?fail=true";
		} else {
			defaultFailURL = "/login?fail=true";
		}

		request.setAttribute("loginFailMassage", loginFailMassage);
		request.setAttribute("member_id_name", member_id);

		request.getRequestDispatcher(defaultFailURL).forward(request, response);
	}
}