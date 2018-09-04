package domean.security.social;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * 
 * @author CM
 * @version 1.0 , 2017.12.13 작성
 * @see none
 */
	
@Controller
	public class SocialConfig
	{/*
	    public static final String APPID ="507921746273443";
	    public static final String APPSECRET ="027f445fa68499e477461748b95c0130";
	
	    
	    
	    @RequestMapping(value="facebooklogin") 
		public void facebooklogin(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap
				,HttpSession session,Authentication authentication) throws Exception
		{
	    	System.out.println("@ facebooklogin");
	    	
	        String code= request.getParameter("code");
	        String errorReason= request.getParameter("error_reason");
	        String error= request.getParameter("error");
	        String errorDescription= request.getParameter("error_description");
	        
	        String callbackUrl="http://localhost:8080/facebooklogin";
	        String oauthUrl="https://graph.facebook.com/oauth/access_token"+
	        						"?client_id="+APPID+
	        						"&client_secret="+APPSECRET+
	        						"&redirect_uri="+URLEncoder.encode(callbackUrl, "UTF-8")+
	        						"&code="+code;
	        		
	        String acessToken=getAcessToken(request, oauthUrl, code);
	        setAccessToken(request, acessToken);
	        onAuthenticationBinding(acessToken);
	        
	    	response.sendRedirect("member/main");
		}
	    
	    
	    
	    
	   
	     
	
	    
	    
	    
	    
	    
	    
	    *//**
	     * facebook accessToken request
	     * 토큰값 받아옴
	     * @param request
	     * @param oauthUrl 
	     * @param code
	     * @throws Exception
	     *//*
	   public String getAcessToken(HttpServletRequest request, String oauthUrl, String code) throws Exception
	    {
		   String accessToken=null;
		   String faceBoockRequest=null;
		   
		   if(StringUtils.isNotEmpty(code)) 
	        {
	            HttpGet httpGet = new HttpGet(oauthUrl);
	            HttpClient httpClient=HttpClientBuilder .create().build();
	            faceBoockRequest=httpClient.execute(httpGet, new BasicResponseHandler());
	            accessToken=faceBoockRequest.substring(faceBoockRequest.indexOf(":\"")+2, faceBoockRequest.indexOf("\","));
	        }
	     
		   	return accessToken;
	    }
	    
	    
	    
	    
	    *//**
	     * setAccessToken
	     * 토큰값 세션에 저장
	     * @param request
	     * @param accessToken
	     * @throws Exception
	     *//*
	    public void setAccessToken(HttpServletRequest request, String accessToken) throws Exception 
	    {
	        request.getSession().setAttribute("ACCESS_TOKEN", accessToken);
	    }




	    
	    
	    
	    public void onAuthenticationBinding(String acessToken) throws NullPointerException 
	    {
	    	
	    	Facebook facebook = new FacebookTemplate(acessToken);
		    FacebookProfile profile = facebook.userOperations().getUserProfile();
		        
	    	MemberDTO sud=new MemberDTO();
	    	sud.setMember_id(profile.getId());
	    	sud.setMember_name(profile.getName());
	    	sud.setMember_pw("****");
	    	
	    	RoleDTO role=new RoleDTO();
	    	role.setMember_authority("ROLE_USER");
	    	
	    	List<RoleDTO> roles=new ArrayList<RoleDTO>();
	    	roles.add(role);
	    	
	    	sud.setMember_autority(roles);
	    
	    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken
	    		(sud.getMember_id(), sud.getMember_pw(), sud.getMember_autority() );
	    
	    SecurityContextHolder.getContext().setAuthentication(authenticationToken); 
	    	
	    //	return new UsernamePasswordAuthenticationToken();
	    }


































	*/}//END
