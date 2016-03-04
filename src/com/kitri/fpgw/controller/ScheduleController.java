package com.kitri.fpgw.controller;

import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kitri.fpgw.model.ScheduleDto;
import com.kitri.fpgw.model.UserMainDto;
import com.kitri.fpgw.service.ScheduleService;
import com.kitri.fpgw.util.Encoder;

@Controller
@RequestMapping(value="/schedule")
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;
	
	@RequestMapping(value="/select.html")
	public ModelAndView ScheduleSelect(ScheduleDto scheduleDto) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/schedule/schedulemodify");
		
		return mav;
		
	}
	
	@RequestMapping(value="/privateselect.html")
	public ModelAndView PrivateScheduleSelectAll(HttpSession session) throws Exception {
		
		return ScheduleSelectAll("老沥包府 >> 俺牢老沥");
	}
	
	@RequestMapping(value="/teamselect.html")
	public ModelAndView TeamScheduleSelectAll(HttpSession session) throws Exception {
		
		
		return ScheduleSelectAll("老沥包府 >> 傍俺老沥");
	}
	
	
	
	@RequestMapping(value="/insert.html")
	public String ScheduleInsert(ScheduleDto scheduleDto) throws Exception {
		
		if(("001").equals(scheduleDto.getStrSch_Kind_Cd())){
			
			scheduleDto.setStrStart_Hour("00");
			scheduleDto.setStrStart_Minute("00");
			scheduleDto.setStrEnd_Hour("00");
			scheduleDto.setStrEnd_Minute("00");
		}
		
		scheduleDto.setStrTerm_Hour("00");
		scheduleDto.setStrTerm_Minute("00");
		
		scheduleService.ScheduleInsert(scheduleDto);
		
		return "jsp/schedule/schedulelist";
	}
	
	@RequestMapping(value="/modify.html")
	public String ScheduleModify(ScheduleDto scheduleDto) throws Exception {
		
		
		
		return "";
	}
	
	@RequestMapping(value="/delete.html")
	public String ScheduleDelete(ScheduleDto scheduleDto) throws Exception {

		
		return "";
	}
	
	@RequestMapping(value="/calenderview.html")
	public @ResponseBody String CalenderView(@RequestParam("start") String startDate, @RequestParam("end") String endDate, HttpSession session) throws Exception{

		
		
		startDate = startDate.replace("-", "");
		endDate = endDate.replace("-", "");
		
		UserMainDto userMainDto = (UserMainDto) session.getAttribute("userInfo");
		
		ScheduleDto scheduleDto = new ScheduleDto();
		scheduleDto.setStrUser(userMainDto.getStrCode());
		scheduleDto.setStrSearchStartDate(startDate);
		scheduleDto.setStrSearchEndDate(endDate);
		
		ArrayList<ScheduleDto> list = scheduleService.ScheduleSelectAll(scheduleDto);
		
		JSONObject json = new JSONObject();
		JSONArray arraySchedule = new JSONArray();
		
		for(ScheduleDto jsonSchedule : list){
			
			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("id", jsonSchedule.getStrYY() + jsonSchedule.getStrMM() + jsonSchedule.getStrDD() + jsonSchedule.getIntSeq());

			if(("001").equals(jsonSchedule.getStrSch_Kind_Cd())){
				
				//老老
				jsonObject.put("allDay", "1");
				jsonObject.put("start", jsonSchedule.getStrYY() + "-" + jsonSchedule.getStrMM() + "-" + jsonSchedule.getStrDD());
				jsonObject.put("end", jsonSchedule.getStrYY() + "-" + jsonSchedule.getStrMM() + "-" + jsonSchedule.getStrDD());
				jsonObject.put("color", "#F2D69B");
			} else {
				
				//矫埃
				jsonObject.put("allDay", "0");
				jsonObject.put("start", jsonSchedule.getStrYY() + "-" + jsonSchedule.getStrMM() + "-" + jsonSchedule.getStrDD() + "T" + jsonSchedule.getStrStart_Hour() + ":" + jsonSchedule.getStrStart_Minute() + ":00");
				jsonObject.put("end", jsonSchedule.getStrYY() + "-" + jsonSchedule.getStrMM() + "-" + jsonSchedule.getStrDD() + "T" + jsonSchedule.getStrEnd_Hour() + ":" + jsonSchedule.getStrEnd_Minute() + ":00");
				jsonObject.put("color", "#7BB4E0");
			}
			jsonObject.put("url", "${root }/schedule/select.html?strUser=" + jsonSchedule.getStrUser() + "&strYY=" + jsonSchedule.getStrYY() + "&strMM=" + jsonSchedule.getStrMM() + "&strDD=" + jsonSchedule.getStrDD() + "&intSeq=" + jsonSchedule.getIntSeq());
			jsonObject.put("title", URLEncoder.encode(jsonSchedule.getStrTitle(), "UTF-8"));
			System.out.println(jsonObject);
			
			arraySchedule.add(jsonObject);
					
		}
		
		json.put("event", arraySchedule);
		return json.toJSONString();
	}
	
	private ModelAndView ScheduleSelectAll(String strKind) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/schedule/schedulelist");
		mav.addObject("menuCategory", strKind);
		
		
		return mav;
	}


}
