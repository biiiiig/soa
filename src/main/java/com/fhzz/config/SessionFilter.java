package com.fhzz.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fhzz.model.User;


@WebFilter(filterName="myFilter",urlPatterns="/*")
public class SessionFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("过滤器销毁");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("=======================================");
		HttpServletRequest hsq = (HttpServletRequest)req;
		User u = (User)hsq.getSession().getAttribute("loginUser");
		
		
		
		if(u==null) {
			((HttpServletResponse)res ).sendRedirect(hsq.getContextPath()+"/user/login");
		}
		
		chain.doFilter(req, res);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		  System.out.println("过滤器初始化");
	}

}
