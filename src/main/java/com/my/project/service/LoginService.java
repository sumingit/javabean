package com.my.project.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

public interface LoginService {
	Map<String, Object> loginCheck(String mid, String passwd, HttpSession session);
}
