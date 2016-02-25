package com.kitri.fpgw.model;

public class ProcedureParameterKeyDto {

	private String strWork_ID;
	private String strWork_User;
	
	public ProcedureParameterKeyDto() {
	}

	public ProcedureParameterKeyDto(String strWork_ID, String strWork_User) {
		this.strWork_ID = strWork_ID;
		this.strWork_User = strWork_User;
	}

	public String getStrWork_ID() {
		return strWork_ID;
	}

	public void setStrWork_ID(String strWork_ID) {
		this.strWork_ID = strWork_ID;
	}

	public String getStrWork_User() {
		return strWork_User;
	}

	public void setStrWork_User(String strWork_User) {
		this.strWork_User = strWork_User;
	}
	
}
