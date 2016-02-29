package com.kitri.fpgw.service;

import java.util.ArrayList;

import org.springframework.http.HttpRequest;

import com.kitri.fpgw.model.UserDto;
import com.kitri.fpgw.model.UserModifyDto;

public interface UserService {

	public UserDto UserSelect(String strCode) throws Exception;
	public ArrayList<UserDto> UserSelectAll() throws Exception;
	public void UserInsert(UserModifyDto userModifyDto, HttpRequest request) throws Exception;
	public void UserModify(UserModifyDto userModifyDto) throws Exception;
	public void UserDelete(String strCode) throws Exception;
}
