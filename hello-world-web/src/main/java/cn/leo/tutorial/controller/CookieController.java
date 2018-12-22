package cn.leo.tutorial.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/cookie")
@Slf4j
public class CookieController {

	// http://localhost:8080/hello-world-web/cookie/getcreate?browser=chrome
	@RequestMapping("getcreate")
	@ResponseBody
	public String getCookie(@RequestParam("browser") String browser, HttpServletRequest request, HttpSession session) {
		Object sesssionBrowser = session.getAttribute("browser");
		if (sesssionBrowser == null) {
			log.debug("no session, set browser= {}", sesssionBrowser);
			session.setAttribute("browser", browser);
		} else {
			log.debug("has browser, browser= {}", sesssionBrowser);
		}
		
		Cookie[] cookies=request.getCookies();
		if(cookies==null){
			return "no cookie";
		}
		for(Cookie cookie:cookies){
			log.debug("cookie info: {}: {}",cookie.getName(),cookie.getValue());
		}
		
		
		return "index";
	}
}
