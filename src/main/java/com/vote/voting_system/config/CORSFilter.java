package com.vote.voting_system.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CORSFilter implements Filter{
	
	private final Logger LOGGER = LoggerFactory.getLogger("CORSFilter");

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filter) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest requestToUse = (HttpServletRequest) req;
		HttpServletResponse responseToUse = (HttpServletResponse) res;
		
		responseToUse.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		responseToUse.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
		responseToUse.setHeader("Access-Control-Allow-Methods", requestToUse.getHeader("Origin"));
		filter.doFilter(requestToUse, responseToUse);
	}*/
	
	  @Override
	  public final void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain) throws IOException, ServletException {
	      final HttpServletResponse response = (HttpServletResponse) res;
	      
	      if (req instanceof HttpServletRequest) {
	    	  String url = ((HttpServletRequest)req).getRequestURL().toString();
	    	  String queryString = ((HttpServletRequest)req).getQueryString();
	    	 // System.out.println( "ORIGIN URL = " + url + "?" + queryString);
	    	  LOGGER.info( "ORIGIN URL = " + url + "?" + queryString);
	     }
	     
	      
	      //response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
	      response.setHeader("Access-Control-Allow-Origin", "*");

	      // without this header jquery.ajax calls returns 401 even after successful login and SSESSIONID being succesfully stored.
	      response.setHeader("Access-Control-Allow-Credentials", "true");

	      response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
	      response.setHeader("Access-Control-Max-Age", "3600");
	      response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Authorization, Origin, Content-Type, Version");
	      response.setHeader("Access-Control-Expose-Headers", "X-Requested-With, Authorization, Origin, Content-Type");

	      final HttpServletRequest request = (HttpServletRequest) req;
	      if (!request.getMethod().equals("OPTIONS")) {
	          chain.doFilter(req, res);
	      } else {
	          // do not continue with filter chain for options requests
	      }
	  }

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

}
