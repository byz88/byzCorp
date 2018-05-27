package com.byzCorp.controller;

import com.byzCorp.service.ILookUpBus;
import com.byzCorp.util.MException;
import com.byzCorp.util.Util;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller(value = "lookUpController")
@RequestMapping(value = "/lookUp/*")
public class LookUpController {
	
	@Autowired
	private ILookUpBus lookUpBus;

	@RequestMapping(value = "/getLookUps")
	public void getLookUps(HttpServletRequest request, HttpServletResponse response) throws IOException {
		JSONObject data = JSONObject.fromObject(request.getParameter("data"));
		String query = Util.reqString(request.getParameter("query"),null);
		Integer start = Util.reqInteger(request.getParameter("start"),0);
		Integer limit = Util.reqInteger(request.getParameter("limit"),20);
		JSONObject sendJSON = lookUpBus.getLookUps(data, query, start, limit);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(sendJSON.toString());
	}

	@RequestMapping(value = "/getLookUpDetails")
	public void getLookUpDetails(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer start = Util.reqInteger(request.getParameter("start"),0);
		Integer limit = Util.reqInteger(request.getParameter("limit"),20);
		Long lookUpId = Util.reqLong(request.getParameter("lookUpId"),null);
		String query = Util.reqString(request.getParameter("query"),null);
		JSONObject sendJSON = lookUpBus.getLookUpDetails(lookUpId, query, start, limit);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(sendJSON.toString());
	}

	@RequestMapping(value = "/saveOrUpdateLookUpDetail")
	public void saveOrUpdateLookUpDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, MException {
		JSONObject data = JSONObject.fromObject(request.getParameter("data"));
		Long lookUpId = Util.reqLong(request.getParameter("lookUpId"),null);
		JSONObject sendJSON = lookUpBus.saveOrUpdateLookUpDetail(data, lookUpId);
		response.getWriter().write(sendJSON.toString());
	}

	@RequestMapping(value = "/removeLookUpDetail")
	public void removeLookUpDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, MException {
		Long lookUpDetailId = Util.reqLong(request.getParameter("lookUpDetailId"),null);
		JSONObject sendJSON = lookUpBus.removeLookUpDetail(lookUpDetailId);
		response.getWriter().write(sendJSON.toString());
	}

	@RequestMapping(value = "/removeLookUp")
	public void removeLookUp(HttpServletRequest request, HttpServletResponse response) throws IOException, MException {
		Long lookUpId = Util.reqLong(request.getParameter("lookUpId"),null);
		JSONObject sendJSON = lookUpBus.removeLookUp(lookUpId);
		response.getWriter().write(sendJSON.toString());
	}

	@RequestMapping(value = "/saveOrUpdateLookUp")
	public void saveOrUpdateLookUp(HttpServletRequest request, HttpServletResponse response) throws IOException, MException {
		JSONObject data = JSONObject.fromObject(request.getParameter("data"));
		JSONObject sendJSON = lookUpBus.saveOrUpdateLookUp(data);
		response.getWriter().write(sendJSON.toString());
	}

}
