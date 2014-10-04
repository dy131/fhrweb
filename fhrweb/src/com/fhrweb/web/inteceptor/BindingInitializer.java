package com.fhrweb.web.inteceptor;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BindingInitializer implements WebBindingInitializer{

	public void initBinder(WebDataBinder webDataBinder, WebRequest webRequest) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
}
