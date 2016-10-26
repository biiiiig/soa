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

import org.apache.http.HttpResponse;

import com.fhzz.model.User;



/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 于起超
 * @date 2016年10月26日 下午4:30:16
 * @vision v1.0
 */ 
@WebFilter(filterName="sessionFilter",urlPatterns="/*")
public class SessionFilterConfig implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		if (!"/user/login".equals(httpRequest.getServletPath())) {
			User user = (User) httpRequest.getSession().getAttribute("loginUser");
			if (user == null) {
				((HttpServletResponse) response).sendRedirect(httpRequest.getContextPath()+ "/user/login");
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}



}
