package domean.security.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Service;

public class FacebookAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
/*
	public static final String APPID = "";
	public static final String APPSECRET = "";

	private final class AuthenticationExceptionExtension extends AuthenticationException {
		private static final long serialVersionUID = 1L;

		private AuthenticationExceptionExtension(String msg) {
			super("/facebooklogin");
		}
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		String code = request.getParameter("code");
		String callbackUrl = "http://localhost:8080/facebooklogin";
		String oauthUrl = null;

		try {
			oauthUrl = "https://graph.facebook.com/oauth/access_token" + "?client_id=" + APPID + "&client_secret="
					+ APPSECRET + "&redirect_uri=" + URLEncoder.encode(callbackUrl, "UTF-8") + "&code=" + code;
		} catch (UnsupportedEncodingException e1) {
		}

		String accessToken = null;
		String faceBoockRequest = null;
		String facebookAccessToken = null;

		if (StringUtils.isNotEmpty(code)) {
			HttpGet httpGet = new HttpGet(oauthUrl);
			HttpClient httpClient = HttpClientBuilder.create().build();

			try {
				faceBoockRequest = httpClient.execute(httpGet, new BasicResponseHandler());
				facebookAccessToken = faceBoockRequest.substring(faceBoockRequest.indexOf(":\"") + 2,
						faceBoockRequest.indexOf("\","));
			} catch (ClientProtocolException e) {
			} catch (IOException e) {
			}

			Facebook facebook = new FacebookTemplate(facebookAccessToken);
			FacebookProfile profile = facebook.userOperations().getUserProfile();

			MemberDTO sud = new MemberDTO();
			sud.setMemberId(profile.getId());
			sud.setMemberName(profile.getName());
			sud.setMemberPw("****");

			RoleDTO role = new RoleDTO();
			role.setMember_authority("ROLE_USER");

			List<RoleDTO> roles = new ArrayList<RoleDTO>();
			roles.add(role);

			sud.setMemberAutority(roles);

			return new UsernamePasswordAuthenticationToken(sud, "cred");
		} else {
			throw new AuthenticationExceptionExtension("Cannot find _code_ parameter");
		}

	}

	@Override
	protected String obtainPassword(HttpServletRequest request) {
		return super.obtainPassword(request);
	}

	@Override
	protected String obtainUsername(HttpServletRequest request) {
		return super.obtainUsername(request);
	}

	@Override
	protected void setDetails(HttpServletRequest request, UsernamePasswordAuthenticationToken authRequest) {
		super.setDetails(request, authRequest);
	}

	@Override
	public void setUsernameParameter(String usernameParameter) {
		super.setUsernameParameter(usernameParameter);
	}

	@Override
	public void setPasswordParameter(String passwordParameter) {
		super.setPasswordParameter(passwordParameter);
	}

	@Override
	public void setPostOnly(boolean postOnly) {
		super.setPostOnly(postOnly);
	}

	@Override
    public void afterPropertiesSet() {
    	super.afterPropertiesSet();
    }*/
}