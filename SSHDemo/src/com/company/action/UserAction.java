package com.company.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.company.service.dto.vo.User;
import com.company.service.iservice.LoginService;
import com.opensymphony.xwork2.ModelDriven;

@Controller("userAction")
@Scope("prototype")
public class UserAction implements ModelDriven<User>, SessionAware {

	@Autowired
	private LoginService loginService;

	// 1-取值
	private User userModel = new User();

	@Override
	public User getModel() {
		return userModel;
	}

	private Map<String, Object> sessionMap;

	@Override
	public void setSession(Map<String, Object> sessionMapFromStruts2) {
		sessionMap = sessionMapFromStruts2;

	}

	// 2-处理

	public String login() {
		String msg = loginService.login(userModel.getLogin());
		if ("success".equals(msg)) {
			sessionMap.put("username", userModel.getLogin().getUsername());
		}
		return msg;
	}

	public String registry() {
		return loginService.registry(userModel);

	}

}
