package com.kitri.fpgw.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kitri.fpgw.model.ScheduleDto;
import com.kitri.fpgw.model.UserMainDto;
import com.kitri.fpgw.service.ScheduleService;

@Controller
@RequestMapping(value="/schedule")
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;
	
	@RequestMapping(value="/select.html")
	public ModelAndView ScheduleSelect(ScheduleDto scheduleDto) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/schedule/schedulemodify");

		if(scheduleDto.getStrUser() != ""){
			
		}
		return mav;
		
	}
	
	@RequestMapping(value="/privateselect.html")
	public ModelAndView PrivateSelectAll(ScheduleDto scheduleDto, HttpSession session) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/schedule/schedulelist");
		mav.addObject("menuCategory", "일정관리 >> 개인일정");
		
		//사용자 아이디 가져오기
		UserMainDto userMainDto = (UserMainDto) session.getAttribute("userInfo");
		System.out.println(userMainDto.getStrCode());
		return mav;
	}
	
	@RequestMapping(value="/teamselect.html")
	public ModelAndView TeamSelectAll(ScheduleDto scheduleDto, HttpSession session) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/schedule/schedulelist");
		mav.addObject("menuCategory", "일정관리 >> 공개일정");
		//사용자 팀정보 가져오기
		UserMainDto userMainDto = (UserMainDto) session.getAttribute("userInfo");
		System.out.println(userMainDto.getStrDepart_Cd());
		return mav;
	}
	
	@RequestMapping(value="/insert.html")
	public String ScheduleInsert(ScheduleDto scheduleDto) throws Exception {
		
		
		return "";
	}
	
	@RequestMapping(value="/modify.html")
	public String ScheduleModify(ScheduleDto scheduleDto) throws Exception {
		
		
		
		return "";
	}
	
	@RequestMapping(value="/delete.html")
	public String ScheduleDelete(ScheduleDto scheduleDto) throws Exception {
		
		
		return "";
	}
}
