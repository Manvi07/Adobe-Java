package com.adobe.prj.web;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD
		}
					, urlPatterns = { "*.jsp" })
public class SecurityFilter implements Filter {

    public SecurityFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		if(! req.getRequestURI().endsWith("login.jsp")) {
			Cookie cookie = new Cookie("uri", req.getRequestURI());
			res.addCookie(cookie);
		}
		
		System.out.println(req.getRequestURI());
		HttpSession session = req.getSession(false);
		if( (session != null && session.getAttribute("user") != null) 
				|| req.getRequestURI().endsWith("login.jsp")) {
			chain.doFilter(request, response);
		} else {
			res.sendRedirect("login.jsp");
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
