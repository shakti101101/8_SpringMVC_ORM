package com.springmvc.service;

import java.util.List;

import org.json.JSONArray;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.entity.FileExcelRead;
import com.springmvc.entity.User;

public interface UserService {

	public int saveUser(User user);

	public List<User> dispalyUser();

	
	public JSONArray dispalyUser2();

	public List<User> edituser(int id);

	public String updateUser(User user);

	public String userdelete(int n);

	public FileExcelRead excelSaveData (MultipartFile file,String path);

	public String loginUserList(String username1,String password1);

	public void ExcelWrite();

	public String reportDate(String fromdate, String todate);

	
	
}
