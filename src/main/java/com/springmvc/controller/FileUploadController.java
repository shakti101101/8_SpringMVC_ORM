package com.springmvc.controller;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.util.HttpSessionMutexListener;

import com.springmvc.helper.Helper;
import com.springmvc.service.UserService;


@Controller
public class FileUploadController {

	@Autowired
	private UserService userService;

	
	@RequestMapping("/fileform")
	public String showUploadForm()
	{
		System.out.println("file uploadController @@@@@@@@@");
		return "fileform";
	}

	@RequestMapping(value="/uploadimpage" ,method =RequestMethod.POST )
	public String fileUpload(@RequestParam("examplecontrolfile") CommonsMultipartFile file,HttpSession s,Model model)
	{
		System.out.println("file upload handler !!!!!!!!!");

		System.out.println(file.getSize());
		System.out.println(file.getName());
		System.out.println(file.getContentType());
		System.out.println(file.getOriginalFilename());
		byte[] data=file.getBytes();
		//we have svae to server
		String path=s.getServletContext().getRealPath("/")+"WEB-INF"+File.separator+"resources"+File.separator+"Excel-File"+File.separator+file.getOriginalFilename();
		System.out.println("path>>>>>>>"+path);
		try {
          FileOutputStream fos=new FileOutputStream(path);
          fos.write(data);
          fos.close();
          //if(Helper.checkExcelFormat(file)) {
        	  
        	  this.userService.excelSaveData(file,path);
         // }
          System.out.println("file uploaded");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Uploding error !!!!!!!!!!!!");

		}
		//model.addAttribute("filename", file.getOriginalFilename());
		return "fileform";
	}
}
