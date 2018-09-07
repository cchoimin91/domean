package domean.security.social;
import org.springframework.stereotype.Controller;



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
	    public static final String APPSECRET ="";
	
	    
	    
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
