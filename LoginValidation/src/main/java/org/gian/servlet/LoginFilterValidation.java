package org.gian.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class LoginFilterValidation
 */
@WebFilter("/LoginFilterValidation")
public class LoginFilterValidation implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilterValidation() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		String userId = request.getParameter("uname");
		String Password = request.getParameter("password");
		// pass the request along the filter chain
		if (userId == "Gian" && Password == "Hello") {
		chain.doFilter(request, response);
	}else {
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		httpServletResponse.sendRedirect("error.html");
	}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
