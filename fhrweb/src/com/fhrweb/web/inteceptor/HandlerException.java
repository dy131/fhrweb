package com.fhrweb.web.inteceptor;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class HandlerException implements HandlerExceptionResolver {
	protected Logger log = Logger.getLogger(this.getClass());

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj, Exception ex) {
		if("XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))) {// Ajax 异步请求 响应
			//response.setStatus(500);
			outputResponse(response, "{ret:false, code:-9, msg:\""+convStr(ex.getMessage())+"\"}");
			return null;
		} else {
			ModelAndView mv = new ModelAndView("alert");
			mv.addObject("msg", ex.getMessage());
			return mv;
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

	protected String convStr(String str) {
		if(str==null) return "";
		return str.replaceAll("\"","\\\\\"").replaceAll("\n", "\\\\n").replaceAll("\r", "");
	}

}
