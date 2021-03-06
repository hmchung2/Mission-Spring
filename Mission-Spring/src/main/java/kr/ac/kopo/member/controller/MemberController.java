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

@SessionAttributes({ "userVO" }) //이 어노테이션만 있으면, 리퀘스트가 아니라 세션에 올라가 
@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/login")
	public String loginForm() {		
		return "login/login";
	}
	
//	@PostMapping("/login")
//	public String login(MemberVO member, Model model, HttpSession session) { //스프링에서는 그냥 세션객체 요구하면 그냥 줌.
//		
//		MemberVO userVO = service.login(member);
//		
//		String msg = "";
//		String view = "";
//		if(userVO == null) {
//			msg = "아이디 또는 패스워드가 잘못되었습니다.";
//			view = "login/login";
//			model.addAttribute("msg", msg);
//		} else {
//			//세션등록 새방법(세션등록마저 디스패처한테 짬 때릴래, 위에 어노테이션 붙이면 됨.)
//			model.addAttribute("userVO", userVO);
//			msg = "환영합니다. " + userVO.getName() + "님";
//			session.setAttribute("msg", msg);
//			
//			//이제 로그인 후에 그냥 가면 안되고 직전 페이지로 가게함.
//			String dest = (String)session.getAttribute("dest");
//			System.out.println("dest : "  + dest);
//			if(dest != null) {
//				session.removeAttribute("dest");
//				view = "redirect:" + dest;
//			} else {
//				view = "redirect:/";				
//			}
//		}
//		System.out.println("view : " +  view);
//		return view;
//	}
	
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
	public String logout(SessionStatus sessionStatus) {
		
		System.out.println("세션삭제 전: " + sessionStatus.isComplete());
		sessionStatus.setComplete();
		System.out.println("세션삭제 후: " + sessionStatus.isComplete());
		
		return "redirect:/";
	}
	
//	@GetMapping("/logout")
//	public String logout(HttpSession session) {
//		
//		//세션어트리뷰트(어노)를 사용한 이상 내가 여기서 session을 직접 조작할 수 없어.
//		session.invalidate();
//		
//		return "redirect:/";
//	}
	
}
