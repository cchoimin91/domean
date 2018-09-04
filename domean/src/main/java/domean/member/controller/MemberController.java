package domean.member.controller;

import java.util.InputMismatchException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import domean.member.dao.MemberDAO;
import domean.member.model.MemberDTO;
import domean.member.service.MemberService;
import domean.security.hendler.LoginSuccessHandler;

@Controller
public class MemberController {
	
	private static Logger logger = Logger.getLogger(MemberController.class.getName());
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	
	
	
	
	@RequestMapping("newmember/insert")
	public String newMemberInsert(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap,
			@ModelAttribute("memberInfo") MemberDTO memberInfo, RedirectAttributes redirectAttributes) throws Exception {

		logger.info("newMemberInsert - 회원가입");
		
		String result = null;
		
		if (memberInfo == null) {
			return "redirect:/index";
		}

		String bcryptPassword = null;
		try {
			bcryptPassword = passwordEncoder.encode(memberInfo.getMemberPw());
			memberInfo.setMemberPw(bcryptPassword);
			memberService.insertJoinMember(memberInfo);
			redirectAttributes.addFlashAttribute("result", "1");
		} catch (InputMismatchException e) {
			logger.severe(e.getMessage());
			redirectAttributes.addFlashAttribute("result", "0");
		}

		return "redirect:/index";
	}

}
