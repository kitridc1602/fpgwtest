package com.kitri.fpgw.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kitri.fpgw.model.ProcedureParameterKeyDto;
import com.kitri.fpgw.model.UserBFModifyDto;
import com.kitri.fpgw.model.UserDto;
import com.kitri.fpgw.model.UserModifyDto;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public UserDto UserSelect(String strCode) throws Exception {
		
		return (UserDto) sqlSessionTemplate.selectOne("userSelect", strCode);
	}

	@Override
	public ArrayList<UserDto> UserSelectAll() throws Exception {
		
		List<UserDto> list = sqlSessionTemplate.selectList("userSelectAll");
		
		return (ArrayList<UserDto>) list;
	}

	@Override
	public void UserInsert(UserDto userDto) throws Exception {

		sqlSessionTemplate.insert("userInsert", userDto);
	}

	@Override
	public void UserModify(UserModifyDto userModifyDto) throws Exception {
		
		if(sqlSessionTemplate.insert("userModifyTempInsert", userModifyDto) > 0){
			
			ProcedureParameterKeyDto procedureParameterKeyDto = new ProcedureParameterKeyDto(userModifyDto.getStrWorkID(), userModifyDto.getStrWork_User());
			
			sqlSessionTemplate.update("userModify", procedureParameterKeyDto);
		}
	}

	@Override
	public void UserDelete(String strCode) throws Exception {

		sqlSessionTemplate.delete("userDelete", strCode);
	}

}
