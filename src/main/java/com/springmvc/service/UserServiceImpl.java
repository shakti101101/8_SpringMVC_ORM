package com.springmvc.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.springmvc.entity.FileExcelRead;
import com.springmvc.entity.Login;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.dao.UserDao;
import com.springmvc.entity.User;
import com.springmvc.helper.Helper;
import com.springmvc.entity.FileExcelRead;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public int saveUser(User user) {
		int i = userDao.save(user);
		return i;
	}

	public List<User> dispalyUser() {
		// TODO Auto-generated method stub
		return  userDao.dispalyUser();
	}

	public JSONArray dispalyUser2() {
		// TODO Auto-generated method stub
		return userDao.dispalyUser2();
	}


	public List<User> edituser(int id) {
		// TODO Auto-generated method stub
		return userDao.editUser(id);
	}

	public String updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	public String userdelete(int n) {
		// TODO Auto-generated method stub
		return userDao.userdelete(n);
	}

	public FileExcelRead excelSaveData(MultipartFile file,String path) {
		// TODO Auto-generated method

		return userDao.excelSaveData(file,path);
	}

	public String loginUserList(String username1,String password1){
		// TODO Auto-generated method stub
		return userDao.loginUserList(username1, password1);
	}

	public void ExcelWrite() {
		// TODO Auto-generated method stub
		 userDao.ExcelWrite();
	}

	public String reportDate(String fromdate, String todate) {
		// TODO Auto-generated method stub
		return this.userDao.reportDate(fromdate,todate);
	}

}
