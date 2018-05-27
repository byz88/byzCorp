package com.byzCorp.login.controller;import java.io.Console;import java.io.IOException;import com.byzCorp.login.service.IUserBus;import com.byzCorp.util.MException;import com.byzCorp.util.Util;import net.sf.json.JSONArray;import net.sf.json.JSONObject;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Controller;import org.springframework.web.bind.annotation.RequestMapping;import javax.servlet.http.HttpServletRequest;import javax.servlet.http.HttpServletResponse;@Controller(value = "userController")@RequestMapping(value = "/user/*")public class UserController {		@Autowired	private IUserBus userBus;	@RequestMapping(value = "/getUser")	public void getUser(HttpServletRequest request, HttpServletResponse response) throws IOException, MException {		JSONObject data = JSONObject.fromObject(request.getParameter("data"));		JSONObject sendJSON = userBus.getUser(data);		response.getWriter().write(sendJSON.toString());	}	@RequestMapping(value = "/getSession")	public void getSession(HttpServletRequest request, HttpServletResponse response) throws IOException, MException {		JSONObject sendJSON = userBus.getSession();		response.getWriter().write(sendJSON.toString());	}	@RequestMapping(value = "/getUsersHql")	public void getUsersHql(HttpServletRequest request, HttpServletResponse response) throws IOException {		Integer start = Util.reqInteger(request.getParameter("start"),0);		Integer limit = Util.reqInteger(request.getParameter("limit"),0);		String query = Util.reqString(request.getParameter("query"),null);		JSONObject sendJSON = userBus.getUsersHql(query,start,limit);		response.getWriter().write(sendJSON.toString());	}	/*@RequestMapping(value = "/getUsersTree")	public void getUsersTree(HttpServletRequest request, HttpServletResponse response) throws IOException {		Long userId = 0L;		if(!request.getParameter("node").equals("root")){			userId = Util.reqLong(request.getParameter("node"),0L);		}		JSONArray jArray = userBus.getUsersTree(userId);		response.getWriter().write(jArray.toString());	}*/}