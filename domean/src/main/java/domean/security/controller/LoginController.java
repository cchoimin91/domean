package domean.security.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import domean.member.dao.MemberDAO;


@Controller
public class LoginController {
	@Autowired
	MemberDAO memberDAO;

	
	
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, ModelMap modelMap) {
		
		Map<String, ?> redirectMap = RequestContextUtils.getInputFlashMap(request);
		
		String msg = null;
		
		if(redirectMap!=null) {
			msg = (String) redirectMap.get("result");
		}
		
		modelMap.addAttribute("msg", msg);
		return "etc/index";
	}

	
	
	
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, ModelMap modelMap) {
		return "etc/login";
	}
	
	

	
	
	
	
	@RequestMapping(value = "/accessdenied")
	public String accessDenied(HttpServletRequest request, ModelMap modelMap) {
		System.out.println("@ accessDenied");
		return "etc/accessDenied";
	}

}// END
