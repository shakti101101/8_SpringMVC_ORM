package com.springmvc.dao;

import java.util.List;
import com.springmvc.entity.FileExcelRead;
import com.springmvc.entity.Login;

import org.json.JSONArray;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.entity.User;

public interface UserDao {

	List<User> dispalyUser();

	JSONArray dispalyUser2();

	int save(User user);

	List<User> editUser(int id);

	 String updateUser(User user);

	String userdelete(int n);


	FileExcelRead excelSaveData(MultipartFile file,String path);

	String loginUserList(String username1,String password1);

	String ExcelWrite();

	String reportDate(String fromdate, String todate);


}
