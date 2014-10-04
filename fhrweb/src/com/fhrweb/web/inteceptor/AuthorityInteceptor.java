package com.fhrweb.web.inteceptor;

import com.fhrweb.util.CookieUtil;
import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthorityInteceptor implements HandlerInterceptor {
	protected Logger log = Logger.getLogger(this.getClass());
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		HandlerMethod method = (HandlerMethod)obj;
		//log.debug(method.getBeanType().getName()+"-"+method.getMethod().getName());
		
		
		return true;
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView modelAndView) throws Exception {
		
		if(modelAndView!=null) {
			modelAndView.addObject("_appPath", request.getContextPath());
		}
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception ex) throws Exception {
		if(ex!=null) {
			log.error(obj.toString(), ex);
		}
	}

	protected void outputResponse(HttpServletResponse response, String str) {
		response.setContentType("text/html; charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.print(str);
			out.close();
		} catch (IOException e) {
			log.error(e);
		}
	}


}
