package com.kitri.fpgw.service;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kitri.fpgw.dao.UserDao;
import com.kitri.fpgw.model.UserDto;
import com.kitri.fpgw.model.UserModifyDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDto UserSelect(String strCode) throws Exception {

		return userDao.UserSelect(strCode);
	}

	@Override
	public ArrayList<UserDto> UserSelectAll() throws Exception {

		return userDao.UserSelectAll();
	}

	@Override
	public void UserInsert(UserModifyDto userModifyDto, HttpRequest request) throws Exception {

		userDao.UserInsert(userModifyDto);
		
		
	}

	@Override
	public void UserModify(UserModifyDto userModifyDto) throws Exception {

		userDao.UserModify(userModifyDto);
	}

	@Override
	public void UserDelete(String strCode) throws Exception {

		userDao.UserDelete(strCode);
	}

	private void UserFileUpload(HttpRequest request){
		
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		MultipartFile multipartFile = null;
		while(iterator.hasNext()){
			
			multipartFile = multipartHttpServletRequest.getFile(iterator.next());
			if(multipartFile.isEmpty() == false){
				
				System.out.println("-------------file start-------------");
				System.out.println("name : " + multipartFile.getName() + " ");
				System.out.println("filename : " + multipartFile.getOriginalFilename() + " ");
				System.out.println("size : " + multipartFile.getSize() + " ");
				System.out.println("-------------file end-------------");
				
			}
		}
		
	}
	
}
