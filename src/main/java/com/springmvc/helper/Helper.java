package com.springmvc.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.entity.FileExcelRead;

public class Helper {

	// check that file is of excel type or not
	public static boolean checkExcelFormat(MultipartFile file)
	{
		String contentType=file.getContentType();
		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
		{
			return true;
		} 

	}

	public static List<FileExcelRead> convertExcelToList(InputStream is){
		
		
		List<FileExcelRead>list=new ArrayList<FileExcelRead>();
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(is);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			int rownumber=0;
			Iterator <Row> iterator=sheet.iterator();
			int cid =0;
			FileExcelRead p=new FileExcelRead();
			while(iterator.hasNext())
			{
				Row row =iterator.next();
				if(rownumber==0)
				{
					rownumber++;
					continue;
				}
				Iterator<Cell> cells=row.iterator();
				while(cells.hasNext()) {
					Cell cell=cells.next();
					
					switch(cid)
					{
//					case 0:
//						p.setId((int)cell.getNumericCellValue());
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
			}
			
		} catch (Exception e) {
e.printStackTrace();		}
		return list;
		
	}
}
