package domean.admin.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.maven.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import domean.member.controller.MemberController;

@Controller
public class AdminController {
	
	private static Logger logger = Logger.getLogger(AdminController.class.getName());
	//ddddddd
	
	@RequestMapping("admin/main")
	public String adminMain(HttpServletRequest request, HttpServletResponse response,ModelMap model)
	{
		logger.info("admin/main");
		
		return "admin/main";
	}
}
