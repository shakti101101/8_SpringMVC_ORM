package com.springmvc.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.SessionFactory;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.hibernate.query.Query;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.entity.FileExcelRead;
import com.springmvc.entity.Login;
import com.springmvc.entity.ReportData;
import com.springmvc.entity.User;
import com.springmvc.helper.Helper;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;

@Repository
@Transactional
public class UserDaoimpl implements UserDao {
	private static final String AbstractEntityPersister = null;
	//
	// @Autowired
	// private HibernateTemplate hibernateTemplate;
	//
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}// setSessionFactory

	@Transactional
	public int save(User user) {
		int i = (Integer) sessionFactory.getCurrentSession().save(user);
		return i;
	}

	// Session session = ((Object) hibernateTemplate).getCurrentSession();
	// session = sessionFactory.openSession();
	public List<User> dispalyUser() {
		// TODO Auto-generated method stub
		System.out.println("display user DAO !!!!!!!!!");
		JSONArray array = null;
		JSONArray array2 = new JSONArray();
		// JSONObject obj=new JSONObject();
		// Session session = sessionFactory.getCurrentSession();
		List<User> data = sessionFactory.getCurrentSession().createQuery("from User").list();
		// System.out.println(data.toString());
		// for (User da : data) {
		// array=new JSONArray();
		// System.out.println(da);
		// array.add(da.getFullName());
		// array.add(da.getEmail());
		// array.add(da.getPassword());
		// array.add(da.getCheck());
		//// array.add("<button class='btn btn-sm-info'
		// id='editbtn'onclick='Editbtndata(\""+da.getId()+"\")'><i class='fa
		// fa-pencil-square' aria-hidden='true'id=\"edit\" name='edit'></i></button>");
		//// array.add("<button class='btn btn-sm-info' id='editbtn' "
		//// + "onclick='deletebtndata(\""+da.getId()+"\")'><i class='fa fa-trash'"
		//// + " aria-hidden='true'id=\"edit\" name='edit'></i></button>");
		////
		// array2.add(array);
		// }

		System.out.println("data>>>>>>>>" + data);
		return data;
	}

	public JSONArray dispalyUser2() {
		// TODO Auto-generated method stub
		System.out.println("display user DAO !!!!!!!!!");
		JSONArray array = null;
		JSONArray array2 = null;

		try {
			List<User> data = sessionFactory.getCurrentSession().createQuery("from User").list();
			array2 = new JSONArray();
			for (User obj : data) {
				array = new JSONArray();
				array.put(obj.getFullName());
				array.put(obj.getEmail());
				array.put(obj.getPassword());
				array.put(obj.getCheck());
				array.put("<button class='btn btn-sm-info' id='editbtn'onclick='Editbtndata(\"" + obj.getId()
						+ "\")'><i class='fa fa-pencil-square' aria-hidden='true'id=\"edit\" name='edit'></i></button>");
				array.put("<button class='btn btn-sm-info' id='editbtn' " + "onclick='deletebtndata(\"" + obj.getId()
						+ "\")'><i class='fa fa-trash'" + " aria-hidden='true'id=\"edit\" name='edit'></i></button>");

				array2.put(array);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("data>>>>>>>>" + array2);
		return array2;
	}

	public List<User> editUser(int id) {
		System.out.println("id>>>>>>>>" + id);
		Query qer = sessionFactory.getCurrentSession().createQuery("from User where id=:n");
		qer.setParameter("n", (id));
		List<User> listdata = qer.list();
		System.out.println("listdata>>>>" + listdata.toString());
		// for(User data:listdata)
		// {
		// data.getFullName();
		// data.getEmail();
		// data.getCheck();
		// data.getPassword();
		// }
		return listdata;
	}

	public String updateUser(User user) {
		System.out.println("update User DAO @@@@");

		sessionFactory.getCurrentSession().update(user);

		return null;
	}

	public String userdelete(int n) {
		// TODO Auto-generated method stub
		System.out.println("delete DAO @@@@" + n);
		String result = "";
		// sessionFactory.getCurrentSession().delete(n);
		try {

			Query qer = sessionFactory.getCurrentSession().createSQLQuery("delete from user_dtls where id=:n");
			qer.setParameter("n", (n));

			int i = qer.executeUpdate();
			if (i == 0) {
				result = "error";
			} else {
				result = "success";
			}
			System.out.println("result>>>>>>>>>" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// String contentType=file.getContentType();

	// List<FileExcelRead>list=new ArrayList<FileExcelRead>();
	// try {
	//
	// FileInputStream fis=new FileInputStream(new File(file));
	// XSSFWorkbook workbook = new XSSFWorkbook(fis);
	// XSSFSheet sheet=workbook.getSheet("userdata");
	// int rownumber=0;
	// Iterator <Row> iterator=sheet.iterator();
	// int cid =0;
	// FileExcelRead p=new FileExcelRead();
	// while(iterator.hasNext())
	// {
	// Row row =iterator.next();
	// if(rownumber==0)
	// {
	// rownumber++;
	// continue;
	// }
	// Iterator<Cell> cells=row.iterator();
	// while(cells.hasNext()) {
	// Cell cell=cells.next();
	//
	// switch(cid)
	// {
	// case 0:
	// p.setId((int)cell.getNumericCellValue());
	// case 1:
	// p.setFullName(cell.getStringCellValue());
	// case 2:
	// p.setEmail(cell.getStringCellValue());
	// case 3:
	// p.setPassword(cell.getStringCellValue());
	//
	// default:
	// break;
	// }
	// cid++;
	// }
	// list.add(p);
	// }
	// String result=(String)sessionFactory.getCurrentSession().save(list);
	// System.out.println("Result for file data save>>>>"+result );
	// return null;
	//
	// } catch (Exception e) {
	// e.printStackTrace(); }
	//
	//

	public FileExcelRead excelSaveData(MultipartFile file, String path) {

		List<FileExcelRead> list = new ArrayList<FileExcelRead>();
		String result = "";
		try {
			File file2 = new File(path); // creating a new file instance
			FileInputStream fis = new FileInputStream(file2); // obtaining bytes from the file
			// creating Workbook instance that refers to .xlsx file
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0); // creating a Sheet object to retrieve object
			int rownumber = 0;
			Iterator<Row> iterator = sheet.iterator();
			int cid = 0;
			FileExcelRead p = new FileExcelRead();
			while (iterator.hasNext()) {
				Row row = iterator.next();
				if (rownumber == 0) {
					rownumber++;
					// continue;
				} else {
					Iterator<Cell> cells = row.iterator();
					while (cells.hasNext()) {
						Cell cell = cells.next();

						switch (cid) {
						case 1:
							p.setFullName(cell.getStringCellValue());
						case 2:
							p.setEmail(cell.getStringCellValue());
						case 3:
							p.setPassword(cell.getStringCellValue());

						default:
							break;
						}
						cid++;
					}
					list.add(p);
					for (FileExcelRead exceldata : list) {

						result = (String) sessionFactory.getCurrentSession().save(exceldata);
					}
				}
			}
			System.out.println("Result for file data save>>>>" + result);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public String loginUserList(String username1, String password1) {

		System.out.println("Login User List Dao @@@");
		System.out.println("username1>>>>" + username1 + "," + password1);
		String dbausername = null, dbapassword = null;
		// List<Login> datalist = new ArrayList<Login>();
		// List<Object> datalist = new ArrayList<Object>();
		try {
			Query qer = sessionFactory.getCurrentSession().createQuery(
					"SELECT  username,password from Login where username=:username and password=:password");

			qer.setParameter("username", username1);
			qer.setParameter("password", password1);
			List<Object[]> dataList = qer.list();

			// System.out.println("Login data>>>>" + dataList.toString());

			for (Object[] l : dataList) {
				System.out.println("userid: " + l[0]);
				System.out.println("firstName: " + l[1]);
				Login u = new Login();
				// dbausername = u.setUsername(l[0]);
				// dbapassword = u.setPassword(l[1]);

				System.out.println(
						"dbausername>>>" + dbausername + "------------" + "dbapassword>>>>>>>>>>>>" + dbapassword);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dbausername + "-" + dbapassword;
	}

	public String ExcelWrite() {
		System.out.println("excel write code here !!!!");
		try {
			List<User> data = sessionFactory.getCurrentSession().createQuery("from User").list();
			String[] coiumnMNames = sessionFactory.getClassMetadata(User.class).getPropertyNames();

			// AbstractEntityPersister
			// classMetadata=(AbstractEntityPersister).sessionFactory.getClassMetadata(clazz);
			// String []columnName =((SessionFactory)
			// sessionFactory.getCurrentSession()).getClassMetadata(User.class).getPropertyNames();

			String filename = "E:\\excel write\\User_Details1.xls";

			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("User_Details");
			sheet.setDefaultColumnWidth(30);
			// create style for header cells
			// create style for header cells
			CellStyle style = workbook.createCellStyle();
			Font font = workbook.createFont();
			font.setFontName("Arial");
			style.setFont(font);

			User co = new User();
			// create header row
//			HSSFRow header = sheet.createRow(0);
//			header.createCell(0).setCellValue(co.getId());
//			  header.getCell(0).setCellStyle(style);
//			header.createCell(1).setCellValue(co.getFullName());
//			  header.getCell(0).setCellStyle(style);
//			header.createCell(2).setCellValue(co.getEmail());
//			  header.getCell(0).setCellStyle(style);
//			header.createCell(3).setCellValue(co.getPassword());
//			  header.getCell(0).setCellStyle(style);
//			header.createCell(4).setCellValue(co.getCheck());
//			  header.getCell(0).setCellStyle(style);   
//			// create data row
			HSSFRow header = sheet.createRow(0);
			for (int i = 0; i < coiumnMNames.length; i++) {
				System.out.println("columnnames :::" + coiumnMNames[i]);
				// create header row
				header.createCell(i).setCellValue(coiumnMNames[i]);
				header.getCell(i).setCellStyle(style);

			}
			int rowCount = 1;
			for (User co1 : data) {

				HSSFRow aRow = sheet.createRow(rowCount++);
				aRow.createCell(0).setCellValue(co1.getEmail());
				aRow.createCell(1).setCellValue(co1.getFullName());
				aRow.createCell(2).setCellValue(co1.getPassword());
				aRow.createCell(3).setCellValue(co1.getId());

			}
			FileOutputStream fileOut = new FileOutputStream(filename);
			// Directory already present this delete and file write code !!!!
			File file = new File(filename);
			if (!file.exists()) {
				System.out.println("Directory does not exist");
				boolean dirCheck = file.mkdir();
				if (dirCheck) {
					System.out.println("Directory is created !!");
				} else {
					System.out.println("Directory cannot be  created !!");
				}
			} else {
				System.out.println("Directory exist !!");
			}
			workbook.write(fileOut);
			// closing the Stream
			fileOut.close();
			// closing the workbook
			workbook.close();
			// prints the message on the console
			System.out.println("Excel file has been generated successfully.");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			e.printStackTrace();
		}
		return null;

	}

	public String reportDate(String fromdate, String todate) {
		System.out.println("DAO !!!!!!!!!!!!!!");
		System.out.println("fromdate **" + fromdate);
		System.out.println("todate **" + todate);

		try {

			// Query qer =sessionFactory.getCurrentSession().createQuery("from ReportData");
			List<ReportData> data = sessionFactory.getCurrentSession().createQuery("from ReportData").list();
			System.out.println(data.toString());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("show error ::" + e);
		}
		return null;
	}
}
