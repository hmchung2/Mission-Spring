package kr.ac.kopo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.ac.kopo.member.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		
		System.out.println("로그인 인터셉터 처리...");
		// 로그인여부 판단.
		HttpSession session = request.getSession();
		MemberVO userVO = (MemberVO) session.getAttribute("userVO");
		if(userVO == null) {
			String uri = request.getRequestURI();
			uri = uri.substring(request.getContextPath().length());
			System.out.println(uri);
			
			session.setAttribute("dest", uri);
			
			// /board/detail?no=3
			// uri : /board/detail request.getRequestURI();
			// query : no=3        request.getQueryString();
			// if(query != null) uri = uri + "?"  query
			
			
			response.sendRedirect(request.getContextPath() +  "/login");
			return false;
		}				
		return true;		
	}
}
