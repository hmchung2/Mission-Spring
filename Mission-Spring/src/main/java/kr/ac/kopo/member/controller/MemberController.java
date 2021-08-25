package kr.ac.kopo.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;

@SessionAttributes("userVO")
@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/login")
	public String loginForm() {
		
		return "login/login";	
	}
	
	@PostMapping("/login")
	public String login(MemberVO member , Model model , HttpSession session){
		
		MemberVO userVO = service.login(member);
		
		service.login(member);
		if(userVO == null) {
			String msg = "아이디 혹은 패스워드가 잘못되었습니다.";
			model.addAttribute("msg", msg);
			return "login/login";
		}
		model.addAttribute("userVO" , userVO);
		
		String dest = (String)session.getAttribute("dest");
		if(dest != null) {
			System.out.println("dest : " + dest);
			session.removeAttribute("dest");
			return "redirect:" + dest;
		}
		
		System.out.println(member);
		session.setAttribute("userVO", userVO);		
		
		return "redirect:/";		
	}
	
	
	@GetMapping("/logout")
	public String logout(/* HttpSession session */ SessionStatus sessionStatus) {
		//session.invalidate();		
		System.out.println(sessionStatus.isComplete());
		sessionStatus.setComplete();
		System.out.println(sessionStatus.isComplete());
		return "redirect:/";
	}
	
}
