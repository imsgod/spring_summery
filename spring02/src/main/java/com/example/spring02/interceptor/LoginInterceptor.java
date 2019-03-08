package com.example.spring02.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final Logger LOGGERS = LoggerFactory.getLogger(LoginInterceptor.class);
	// 메인 액션이 실행되기 전 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		LOGGERS.info("LoginInterceptor 프리 핸들러");
		HttpSession session = request.getSession();
		if (session.getAttribute("userid") == null) {
			response.sendRedirect(request.getContextPath() + 
									"/member/login.do?message=nologin");
			return false;
		} else {
			return true;
		}
		
	}
	
	// 메인 액션이 실행된 후
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
}
