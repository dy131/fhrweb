package com.fhrweb.util;

import javax.servlet.http.*;
import java.io.UnsupportedEncodingException;


public class CookieUtil {
	private static String defaultDomain = "gooooal.com";   //"gooooal.com";

	public static String getCookie(HttpServletRequest request, String cookieName) {
		if (null == cookieName || "".equals(cookieName)) return null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if (cookieName.equals(cookie.getName())) {
					try {
						return java.net.URLDecoder.decode(cookie.getValue(), "utf-8");
					} catch(UnsupportedEncodingException e) {
						System.err.println(e.getClass().getName()+": "+e.getMessage());
					}
				}
			}
		}
		return null;
	}

	public static void setCookie(HttpServletResponse response,
	                             String cookieName, String cookieValue) {
		setCookie(response, defaultDomain, cookieName, cookieValue);
	}

	public static void setCookie(HttpServletResponse response, String domain,
	                             String cookieName, String cookieValue) {
		String path = "/";
		short validTime = -1;
		setCookie(response, cookieName, cookieValue, path, validTime, domain);
	}

	public static void setCookie(HttpServletResponse response,
	                             String cookieName, String cookieValue,
	                             String path, int validTime, String domain) {
		try {
			Cookie cookie = new Cookie(cookieName, cookieValue==null?null:java.net.URLEncoder.encode(cookieValue, "utf-8"));
			cookie.setPath(path);
			cookie.setMaxAge(validTime);
			if (null != domain) cookie.setDomain(domain);
			response.addCookie(cookie);
		} catch(UnsupportedEncodingException e) {
			System.err.println(e.getClass().getName()+": "+e.getMessage());
		}
	}

	public static void removeCookies(HttpServletResponse response, String cookieName) {
		removeCookies(response, defaultDomain, cookieName);
	}

	public static void removeCookies(HttpServletResponse response, String domain, String cookieName) {
		String path = "/";
		short validTime = 0;
		setCookie(response, cookieName, null, path, validTime, domain);
	}

	public static String getIpAddr(HttpServletRequest request) {
		StringBuffer ipAddr = new StringBuffer();
		String ip = request.getHeader("x-forwarded-for");
		if(ip!=null && ip.length()>0 && !"unknown".equalsIgnoreCase(ip))
			ipAddr.append(ip);
		ip = request.getHeader("Proxy-Client-IP");
		if(ip!=null && ip.length()>0 && !"unknown".equalsIgnoreCase(ip) && ipAddr.indexOf(ip)<0) {
			if(ipAddr.length()>0) ipAddr.append(",");
			ipAddr.append(ip);
		}
		ip = request.getHeader("WL-Proxy-Client-IP");
		if(ip!=null && ip.length()>0 && !"unknown".equalsIgnoreCase(ip) && ipAddr.indexOf(ip)<0) {
			if(ipAddr.length()>0) ipAddr.append(",");
			ipAddr.append(ip);
		}
		ip = request.getRemoteAddr();
		if(ip!=null && ip.length()>0 && !"unknown".equalsIgnoreCase(ip) && ipAddr.indexOf(ip)<0) {
			if(ipAddr.length()>0) ipAddr.append(",");
			ipAddr.append(ip);
		}
		return ipAddr.toString();
	}

}
