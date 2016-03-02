package com.kitri.fpgw.dao;

import java.util.ArrayList;


import com.kitri.fpgw.model.RantDetailDto;
import com.kitri.fpgw.model.RantMainDto;

public interface RantDao {

	public void insertReserve(RantMainDto rantMainDto) throws Exception;
	public void insertReserveDetail(RantDetailDto rantDetailDto) throws Exception;
	public String selectApproUser() throws Exception;
	public ArrayList<RantMainDto> CodeManageSelect();
	public ArrayList<RantMainDto> selectTimeCheck(RantMainDto rantMainDto);
	
}
