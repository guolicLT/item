package com.guolic.library.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.guolic.library.util.EmptyUtil;
/*
 * 全局编码过滤器
 */
public class EncodingFilter implements Filter {
	private FilterConfig config;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
//      先转型；
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        String encoding = config.getInitParameter("encoding");
        if (EmptyUtil.isEmpty(encoding)) {
            encoding = "utf-8";
        }
        req.setCharacterEncoding(encoding);
        resp.setContentType("text/jsp;charset="+encoding);
        chain.doFilter(request,response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config = config;
	}


}
