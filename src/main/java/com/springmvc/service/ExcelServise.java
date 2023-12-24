//package com.springmvc.service;
//
//import java.io.IOException;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.springmvc.entity.FileExcelRead;
//import com.springmvc.helper.Helper;
//
//public class ExcelServise {
//
//	
//public  void save (MultipartFile file)
//{
//	try {
//		List<FileExcelRead> p=Helper.convertExcelToList(file.getInputStream());
//		this.product.saveAll(p);
//		
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//}
//public List<FileExcelRead>getAllProduct(){
//	
//	return null;
//	
//}
//
//}
