package domean.main.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import domean.member.model.MemberDTO;



@Controller
public class MainController {

	 
	
	
	@RequestMapping("member/main") 
	public String domeanMain(HttpServletRequest request,ModelMap modelMap,Authentication authentication)  
	{			
		System.out.println("@ domeanMain");
		
		MemberDTO userInfo = (MemberDTO)authentication.getPrincipal(); // @AuthenticationPrincipal
		modelMap.addAttribute("userInfo",userInfo);
		return "main/main";
	}
	
	
	
}
