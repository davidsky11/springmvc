package com.kv.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.kv.model.SystemContext;

public class SystemContextFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		int offset = 0;
		try {
			offset = Integer.parseInt(req.getParameter("pager.offset"));
		} catch (NumberFormatException e) {
			
		}
		try {
			SystemContext.setOffset(offset);
			SystemContext.setSize(15);
			chain.doFilter(req, res);
		} finally {
			SystemContext.removeOffset();
			SystemContext.removeSize();
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
