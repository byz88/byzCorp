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

	@RequestMapping(value = "/getHrDetail")
	public void getHrDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, MException {
		Long userId = Util.reqLong(request.getParameter("userId"),null);
		JSONObject sendJSON = hrBus.getHrDetail(userId);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(sendJSON.toString());
	}

	@RequestMapping(value = "/getHrLeave")
	public void getHrLeave(HttpServletRequest request, HttpServletResponse response) throws IOException, MException {
		Long userId = Util.reqLong(request.getParameter("userId"),null);
		JSONObject sendJSON = hrBus.getHrLeave(userId);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(sendJSON.toString());
	}

	@RequestMapping(value = "/getHrLeaveDetail")
	public void getHrLeaveDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, MException {
		Long userId = Util.reqLong(request.getParameter("userId"),null);
		JSONObject sendJSON = hrBus.getHrLeaveDetail(userId);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(sendJSON.toString());
	}

	@RequestMapping(value = "/saveOrUpdateHr")
	public void saveOrUpdateHr(HttpServletRequest request, HttpServletResponse response) throws IOException, MException {
		JSONObject subInfoWest = JSONObject.fromObject(request.getParameter("subInfoWest"));
		JSONObject subInfoEast = JSONObject.fromObject(request.getParameter("subInfoEast"));
		JSONObject subInfoCenter = JSONObject.fromObject(request.getParameter("subInfoCenter"));
		JSONObject infoWest = JSONObject.fromObject(request.getParameter("infoWest"));
		JSONObject infoEast = JSONObject.fromObject(request.getParameter("infoEast"));
		JSONObject infoCenter = JSONObject.fromObject(request.getParameter("infoCenter"));
		JSONObject hrLeave = JSONObject.fromObject(request.getParameter("hrLeave"));
		//region foto kaydi icin
		//byte[] fileByteArray = Util.getByteArrayImageUpload(request);
		//byte[] scaledImage = Util.scaleImage(fileByteArray);
		//endregion
		JSONObject sendJSON = hrBus.saveOrUpdateHr(subInfoWest,subInfoEast,subInfoCenter,infoWest,infoEast,infoCenter);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(sendJSON.toString());
	}

	@RequestMapping(value = "/saveOrUpdateHrLeave")
	public void saveOrUpdateHrLeave(HttpServletRequest request, HttpServletResponse response) throws IOException, MException {
		JSONObject subInfoWest = JSONObject.fromObject(request.getParameter("subInfoWest"));
		JSONObject subInfoEast = JSONObject.fromObject(request.getParameter("subInfoEast"));
		JSONObject subInfoCenter = JSONObject.fromObject(request.getParameter("subInfoCenter"));
		JSONObject hrLeave = JSONObject.fromObject(request.getParameter("hrLeave"));
		//region foto kaydi icin
		//byte[] fileByteArray = Util.getByteArrayImageUpload(request);
		//byte[] scaledImage = Util.scaleImage(fileByteArray);
		//endregion
		JSONObject sendJSON = hrBus.saveOrUpdateHrLeave(subInfoWest,subInfoEast,subInfoCenter,hrLeave);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(sendJSON.toString());
	}

	@RequestMapping(value = "/saveOrUpdateHrLeaveDetail")
	public void saveOrUpdateHrLeaveDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, MException {
		Integer leaveDetailYear = Util.reqInteger(request.getParameter("leaveDetailYear"),null);
		Integer leaveDetailDay = Util.reqInteger(request.getParameter("leaveDetailDay"),null);
		Long leaveDetailId = Util.reqLong(request.getParameter("leaveDetailId"),null);
		Long userId = Util.reqLong(request.getParameter("userId"),null);
		JSONObject sendJSON = hrBus.saveOrUpdateHrLeaveDetail(leaveDetailId,leaveDetailYear,leaveDetailDay,userId);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(sendJSON.toString());
	}

	@RequestMapping(value = "/removeHrLeaveDetail")
	public void removeHrLeaveDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, MException {
		Long hrLeaveDetailId = Util.reqLong(request.getParameter("hrLeaveDetailId"),null);
		JSONObject sendJSON = hrBus.removeHrLeaveDetail(hrLeaveDetailId);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(sendJSON.toString());
	}

}
