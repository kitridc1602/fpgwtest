package com.kitri.fpgw.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kitri.fpgw.model.UserBFModifyDto;
import com.kitri.fpgw.model.UserDetailModifyDto;
import com.kitri.fpgw.model.UserDto;
import com.kitri.fpgw.model.UserImageModifyDto;
import com.kitri.fpgw.model.UserMainDto;
import com.kitri.fpgw.model.UserMainModifyDto;
import com.kitri.fpgw.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService UserService; 
	
	@RequestMapping(value="/privateselect.html")
	public String UserPrivateSelect(){
		
		return "jsp/user/userprivateupdate";
	}
	
	@RequestMapping(value="/select.html")
	public ModelAndView UserSelect(String strCode) throws Exception{
		
		ModelAndView mav = new ModelAndView();
				
		if(strCode != null){
		
			UserDto userModify = UserService.UserSelect(strCode);
			mav.addObject("userModify", userModify);
			
		}
		
		mav.setViewName("jsp/user/usermanagemodify");
		return mav;
	}
	
	@RequestMapping(value="/selectall.html")
	public ModelAndView UserSelectAll() throws Exception{
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/user/usermanagelist");
		
		ArrayList<UserDto> userDto = UserService.UserSelectAll(); 
		mav.addObject("userDto", userDto);
		
		return mav;
	}

	@RequestMapping(value="/modify.html")
	public String UserModify(@ModelAttribute("userDto") UserDto userDto, HttpSession session) throws Exception{
		
		UserMainDto userMainDto = (UserMainDto) session.getAttribute("userInfo");
		
		UserBFModifyDto userBFModifyDto = new UserBFModifyDto();
		
		userBFModifyDto.setUserMainModifyDto(
				new UserMainModifyDto(
						userDto.getStrCode(), userDto.getStrName(), userDto.getStrID(), userDto.getStrPWD(), 
						userDto.getStrDepart_Cd(), "100", userDto.getStrPosition_Cd(), userDto.getIntLevel(), 
						userDto.getStrCo_Tel1(), userDto.getStrCo_Tel2(), userDto.getStrCo_Tel3(), userDto.getStrCo_Tel_InLine(), 
						userDto.getStrHire_YYYY(), userDto.getStrHire_MM(), userDto.getStrHire_DD(), userDto.getIntVacation_Count(), 
						1, null, null, userMainDto.getStrCode(), null));
		
		
		userBFModifyDto.setUserDetailModifyDto(
				new UserDetailModifyDto(
						userDto.getStrCode(), userDto.getStrGender(), 
						userDto.getStrBirth_YYYY(), userDto.getStrBirth_MM(), userDto.getStrBirth_DD(), userDto.getIntCalender_Kind(), 
						userDto.getStrHome_Tel1(), userDto.getStrHome_Tel2(), userDto.getStrHome_Tel3(), 
						userDto.getStrMobile1(), userDto.getStrMobile2(), userDto.getStrMobile3(), 
						userDto.getStrZip1(), userDto.getStrZip2(), userDto.getStrAddr1(), userDto.getStrAddr2(), 
						userDto.getStrHome_Page(), userDto.getIntWedding_Flag(), 
						userDto.getStrWedding_YYYY(), userDto.getStrWedding_MM(), userDto.getStrWedding_DD(), 
						userDto.getStrHobby(), userDto.getStrResume(), userDto.getStrIntroduction(), null, 
						null, null,  userMainDto.getStrCode(), null));
		
		/*
		userBFModifyDto.setUserImageModifyDto(
				new UserImageModifyDto(
						userDto.getStrCode(), userDto.getStrFace_Name(), userDto.getStrFace_Path(), userDto.getStrSign_Name(), userDto.getStrSign_Path(),  userMainDto.getStrCode(), null));
		*/
		UserService.UserModify(userBFModifyDto);
		
		
		return "jsp/user/usermanagemodify";
	}
	
	@RequestMapping(value="/delete.html")
	public String UserDelete(String code){
		
		
		return "";
	}
	
}
