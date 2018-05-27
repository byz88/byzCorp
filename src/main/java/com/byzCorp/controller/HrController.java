package com.byzCorp.controller;

import com.byzCorp.service.IHrBus;
import com.byzCorp.service.ILookUpBus;
import com.byzCorp.util.MException;
import com.byzCorp.util.Util;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller(value = "hrController")
@RequestMapping(value = "/hr/*")
public class HrController {
	
	@Autowired
	private IHrBus hrBus;

	@RequestMapping(value = "/getUserDetail")
	public void getUserDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, MException {
		Long userId = Util.reqLong(request.getParameter("userId"),null);
		JSONObject sendJSON = hrBus.getUserDetail(userId);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(sendJSON.toString());
	}

	@RequestMapping(value = "/getUserLeave")
	public void getUserLeave(HttpServletRequest request, HttpServletResponse response) throws IOException, MException {
		Long userId = Util.reqLong(request.getParameter("userId"),null);
		JSONObject sendJSON = hrBus.getUserLeave(userId);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(sendJSON.toString());
	}

	@RequestMapping(value = "/saveOrUpdateEmployee")
	public void saveOrUpdateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException, MException {
		JSONObject subInfoWest = JSONObject.fromObject(request.getParameter("subInfoWest"));
		JSONObject subInfoEast = JSONObject.fromObject(request.getParameter("subInfoEast"));
		JSONObject subInfoCenter = JSONObject.fromObject(request.getParameter("subInfoCenter"));
		JSONObject infoWest = JSONObject.fromObject(request.getParameter("infoWest"));
		JSONObject infoEast = JSONObject.fromObject(request.getParameter("infoEast"));
		JSONObject infoCenter = JSONObject.fromObject(request.getParameter("infoCenter"));
		//region foto kaydi icin
		//byte[] fileByteArray = Util.getByteArrayImageUpload(request);
		//byte[] scaledImage = Util.scaleImage(fileByteArray);
		//endregion
		JSONObject sendJSON = hrBus.saveOrUpdateEmployee(subInfoWest,subInfoEast,subInfoCenter,infoWest,infoEast,infoCenter);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(sendJSON.toString());
	}

}
