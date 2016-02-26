package com.kitri.fpgw.dao;

import org.springframework.web.multipart.MultipartFile;

public class FileBeanDto {

	private String strPath;
	private MultipartFile uploadFile;
	private String strFileName;
	private String strCheckEditorFuncNum;
	
	public FileBeanDto() {
	}

	public FileBeanDto(String strPath, MultipartFile uploadFile, String strFileName, String strCheckEditorFuncNum) {
		this.strPath = strPath;
		this.uploadFile = uploadFile;
		this.strFileName = strFileName;
		this.strCheckEditorFuncNum = strCheckEditorFuncNum;
	}

	public String getStrPath() {
		return strPath;
	}

	public void setStrPath(String strPath) {
		this.strPath = strPath;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getStrFileName() {
		return strFileName;
	}

	public void setStrFileName(String strFileName) {
		this.strFileName = strFileName;
	}

	public String getStrCheckEditorFuncNum() {
		return strCheckEditorFuncNum;
	}

	public void setStrCheckEditorFuncNum(String strCheckEditorFuncNum) {
		this.strCheckEditorFuncNum = strCheckEditorFuncNum;
	}

	
	
}
