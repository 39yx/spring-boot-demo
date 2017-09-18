package com.boot.zuul.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class MyFilter extends ZuulFilter {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
		String hh = request.getParameter("hh");
		if(StringUtils.isBlank(hh)){
			ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
				ctx.getResponse().getWriter().write("token is empty");
			} catch (IOException e) {
				e.printStackTrace();
			}
            return null;
		}
		return null;
	}
	
	public static void main(String[] args) {
		/*String value = "25:33";
		int oneDayMinute = 1440;
		String[] hm = value.split(":");
		int minute = Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date first;
		try {
			first = sdf.parse("1900/01/01 00:00");
		} catch (ParseException e) {
			return;
		}
		Calendar calendar = Calendar.getInstance();
		
		calendar.setTime(first);
		//calendar.add(Calendar.MINUTE, minute - oneDayMinute);
		calendar.add(Calendar.HOUR, Integer.parseInt(hm[0]));
		//calendar.add(Calendar.MINUTE, Integer.parseInt(hm[1]));
		System.out.println(sdf.format(calendar.getTime()));*/
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date first;
		try {
			first = sdf.parse("1900/01/01 00:00");
		} catch (ParseException e) {
			return;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(first);//12:30
		System.out.println(calendar.getTimeInMillis());
		System.out.println(sdf.format(new Date(calendar.getTimeInMillis())));
		//calendar.add(Calendar.MINUTE, minute - oneDayMinute);
		calendar.add(Calendar.MINUTE, 8*60);
		
		//calendar.set(Calendar.MINUTE, 30);
		System.out.println(calendar.getTimeInMillis());
		System.out.println(sdf.format(new Date(calendar.getTimeInMillis())));
		//calendar.add(Calendar.MINUTE, Integer.parseInt(hm[1]));
		System.out.println(sdf.format(calendar.getTime()));
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		// pre：路由之前 routing：路由之时 post： 路由之后 error：发送错误调用
		return "pre";
	}

}
