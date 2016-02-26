package com.kitri.fpgw.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kitri.fpgw.dao.FileBeanDto;
import com.kitri.fpgw.model.UserDto;
import com.kitri.fpgw.model.UserModifyDto;
import com.kitri.fpgw.service.UserService;
import com.kitri.fpgw.util.StringClass;

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
						
		return ModuleSelectAll();
	}

	@RequestMapping(value="/insert.html") 
	public ModelAndView UserInsert(UserDto userDto, FileBeanDto fileBean) throws Exception {
		
		if(fileBean != null){
			
			fileBean.getStrFileName();
		}
		
		if(userDto.getStrFace_Name() != ""){
			
			userDto.setStrFace_Path("/img/user/");
		}
		
		if(userDto.getStrSign_Name() != ""){
			
			userDto.setStrSign_Path("/img/user/");
		}
		
		UserModifyDto userModifyDto = new UserModifyDto(
				StringClass.NewWorkIDCreate(), userDto.getStrEdit_User_Cd(), 
				userDto.getStrCode(), userDto.getStrName(), userDto.getStrID(), userDto.getStrPWD(), 
				userDto.getStrDepart_Cd(), "100", userDto.getStrPosition_Cd(), userDto.getIntLevel(),
				userDto.getStrCo_Tel1(), userDto.getStrCo_Tel2(), userDto.getStrCo_Tel3(), userDto.getStrCo_Tel_InLine(),
				userDto.getStrHire_YYYY(), userDto.getStrHire_MM(), userDto.getStrHire_DD(), userDto.getIntVacation_Count(), userDto.getIntUse_Flag(), 
				userDto.getStrGender(), userDto.getStrBirth_YYYY(), userDto.getStrBirth_MM(), userDto.getStrBirth_DD(), userDto.getIntCalender_Kind(),  
				userDto.getStrHome_Tel1(), userDto.getStrHome_Tel2(), userDto.getStrHome_Tel3(),  
				userDto.getStrMobile1(), userDto.getStrMobile2(), userDto.getStrMobile3(),  
				userDto.getStrZip1(), userDto.getStrZip2(), userDto.getStrAddr1(), userDto.getStrAddr2(), 
				userDto.getStrHome_Page(), userDto.getIntWedding_Flag(), userDto.getStrWedding_YYYY(), userDto.getStrWedding_MM(), userDto.getStrWedding_DD(), 
				userDto.getStrHobby(), userDto.getStrResume(), userDto.getStrIntroduction(), "", 
				"", userDto.getStrFace_Path(), "", userDto.getStrSign_Path());
		
		/*UserService.UserInsert(userModifyDto);*/
		
		return ModuleSelectAll();
	}
	
	@RequestMapping(value="/modify.html")
	public ModelAndView UserModify(UserDto userDto) throws Exception{
		
		if(userDto.getStrFace_Name() != ""){
			
			userDto.setStrFace_Name("U" + userDto.getStrCode() + ".jpg");
			userDto.setStrFace_Path("/img/user/");
		}
		
		if(userDto.getStrSign_Name() != ""){
			userDto.setStrSign_Name("S" + userDto.getStrCode() + ".jpg");
			userDto.setStrSign_Path("/img/user/");
		}
		
		UserModifyDto userModifyDto = new UserModifyDto(
				StringClass.NewWorkIDCreate(), userDto.getStrEdit_User_Cd(), 
				userDto.getStrCode(), userDto.getStrName(), userDto.getStrID(), userDto.getStrPWD(), 
				userDto.getStrDepart_Cd(), "100", userDto.getStrPosition_Cd(), userDto.getIntLevel(),
				userDto.getStrCo_Tel1(), userDto.getStrCo_Tel2(), userDto.getStrCo_Tel3(), userDto.getStrCo_Tel_InLine(),
				userDto.getStrHire_YYYY(), userDto.getStrHire_MM(), userDto.getStrHire_DD(), userDto.getIntVacation_Count(), userDto.getIntUse_Flag(), 
				userDto.getStrGender(), userDto.getStrBirth_YYYY(), userDto.getStrBirth_MM(), userDto.getStrBirth_DD(), userDto.getIntCalender_Kind(),  
				userDto.getStrHome_Tel1(), userDto.getStrHome_Tel2(), userDto.getStrHome_Tel3(),  
				userDto.getStrMobile1(), userDto.getStrMobile2(), userDto.getStrMobile3(),  
				userDto.getStrZip1(), userDto.getStrZip2(), userDto.getStrAddr1(), userDto.getStrAddr2(), 
				userDto.getStrHome_Page(), userDto.getIntWedding_Flag(), userDto.getStrWedding_YYYY(), userDto.getStrWedding_MM(), userDto.getStrWedding_DD(), 
				userDto.getStrHobby(), userDto.getStrResume(), userDto.getStrIntroduction(), "", 
				userDto.getStrFace_Name(), userDto.getStrFace_Path(), userDto.getStrSign_Name(), userDto.getStrSign_Path());
	
		/*UserService.UserModify(userModifyDto);*/
		
		return ModuleSelectAll();
	}
	
	@RequestMapping(value="/delete.html")
	public ModelAndView UserDelete(String strCode) throws Exception {
		
		UserService.UserDelete(strCode);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/user/usermanagelist");
		
		ArrayList<UserDto> userDto = UserService.UserSelectAll(); 
		mav.addObject("userDto", userDto);
		
		return mav;
	}
	
	
	private ModelAndView ModuleSelectAll() throws Exception{
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsp/user/usermanagelist");
		
		ArrayList<UserDto> userAllDto = UserService.UserSelectAll(); 
		mav.addObject("userDto", userAllDto);
		
		return mav;
	}
	
}
