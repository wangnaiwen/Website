package controler;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entity.Student;

public class StuExcelCon {
	
	private static List<Student> users;
	
	/**excel 2008*/
	
	public List<Student> readXlsx(String path, String sheet) throws IOException {

		InputStream is = new FileInputStream(path);

		XSSFWorkbook xw = new XSSFWorkbook(is);

		users = new ArrayList<Student>();

		// XSSFSheet mysheet = xw.getSheetAt(0);
		XSSFSheet mysheet = xw.getSheet(sheet);
		if(mysheet == null){
			return null;
		}
		
		for (int rowNum = 0; rowNum <= mysheet.getLastRowNum(); rowNum++) {
			XSSFRow xssfRow = mysheet.getRow(rowNum);
			if (xssfRow != null) {
				Student stu = new Student();
				XSSFCell id = xssfRow.getCell(0);
				XSSFCell name = xssfRow.getCell(1);
				XSSFCell sex = xssfRow.getCell(2);
				XSSFCell birthday = xssfRow.getCell(3); 
				XSSFCell department = xssfRow.getCell(4); 
				XSSFCell major = xssfRow.getCell(5); 
				XSSFCell phoneNumber = xssfRow.getCell(6); 
				XSSFCell qq = xssfRow.getCell(7); 
				XSSFCell wechat = xssfRow.getCell(8); 
				XSSFCell passwd = xssfRow.getCell(9); 
				XSSFCell type = xssfRow.getCell(10); 
				
				if(id != null){
					stu.setSid(getValue(id));
				}
				if(name != null){
					stu.setName(getValue(name));
				}
				if(sex != null){
					stu.setSex(getValue(sex));
				}
				if(birthday != null){
					stu.setBirthday(getValue(birthday));
				}
				if(department != null){
					stu.setDepartment(getValue(department));
				}
				if(major != null){
					stu.setMajor(getValue(major));
				}
				if(phoneNumber != null){
					stu.setPhoneNumber(getValue(phoneNumber));
				}
				if(passwd != null){
					stu.setPassword(getValue(passwd));
				}
				if(qq != null){
					stu.setQq(getValue(qq));
				}
				if(wechat != null){
					stu.setWechat(getValue(wechat));
				}
				if(type != null){
					String t = getValue(type);
					int s = Integer.parseInt(t.substring(0,1));
					stu.setType(s);
				}				
				users.add(stu);
			}
		}
		is.close();
		return users;
	}
	
	/**excel 2007*/
	public List<Student> readXls(String path, String sheet) throws IOException {

		InputStream is = new FileInputStream(path);

		HSSFWorkbook xw = new HSSFWorkbook(is);

		users = new ArrayList<Student>();

		// HSSFSheet mysheet = xw.getSheetAt(0);
		HSSFSheet mysheet = xw.getSheet(sheet);

		if(mysheet == null){
			return null;
		}
		
		for (int rowNum = 0; rowNum <= mysheet.getLastRowNum(); rowNum++) {
			HSSFRow hssfRow = mysheet.getRow(rowNum);
			if (hssfRow != null) {
				Student stu = new Student();
				HSSFCell id = hssfRow.getCell(0);
				HSSFCell name = hssfRow.getCell(1);
				HSSFCell sex = hssfRow.getCell(2);
				HSSFCell birthday = hssfRow.getCell(3); 
				HSSFCell department = hssfRow.getCell(4); 
				HSSFCell major = hssfRow.getCell(5); 
				HSSFCell phoneNumber = hssfRow.getCell(6); 
				HSSFCell qq = hssfRow.getCell(7); 
				HSSFCell wechat = hssfRow.getCell(8); 
				HSSFCell passwd = hssfRow.getCell(9); 
				HSSFCell type = hssfRow.getCell(10); 

				if(id != null){
					stu.setSid(getValue(id));
				}
				if(name != null){
					stu.setName(getValue(name));
				}
				if(sex != null){
					stu.setSex(getValue(sex));
				}
				if(birthday != null){
					stu.setBirthday(getValue(birthday));
				}
				if(department != null){
					stu.setDepartment(getValue(department));
				}
				if(major != null){
					stu.setMajor(getValue(major));
				}
				if(phoneNumber != null){
					stu.setPhoneNumber(getValue(phoneNumber));
				}
				if(passwd != null){
					stu.setPassword(getValue(passwd));
				}
				if(qq != null){
					stu.setQq(getValue(qq));
				}
				if(wechat != null){
					stu.setWechat(getValue(wechat));
				}
				if(type != null){
					String t = getValue(type);
					int s = Integer.parseInt(t);
					stu.setType(s);
				}
				users.add(stu);
			}
		}
		is.close();
		return users;
	}
	
/*	public void updateXlsx(String path, String sheet, Student u){
		try{
			InputStream is = new FileInputStream(path);

			XSSFWorkbook xw = new XSSFWorkbook(is);

			users = new ArrayList<Student>();

			XSSFSheet mysheet = xw.getSheet(sheet);
			
			int j = 0;
			
			for (int rowNum = 0; rowNum < mysheet.getLastRowNum(); rowNum++) {
				XSSFRow xssfRow = mysheet.getRow(rowNum);
				if (xssfRow != null) {
					XSSFCell name = xssfRow.getCell(1);
					String userName = getValue(name);
					if(userName.equals(u.getUserName())){
						j=rowNum;
						break;
					}
				}
			}
			
			XSSFRow xssfRow = mysheet.getRow(j);
			XSSFCell id = xssfRow.createCell(0);
			XSSFCell name = xssfRow.createCell(1);
			XSSFCell pass = xssfRow.createCell(2);
			XSSFCell time = xssfRow.createCell(3);
			
			id.setCellValue(u.getId());
			name.setCellValue(u.getUserName());
			pass.setCellValue(u.getPassword());
			time.setCellValue(u.getMinTime());
			
			is.close();
			OutputStream os = new FileOutputStream(path);
			xw.write(os);
			os.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void updateXls(String path, String sheet, User u){
		try{
			InputStream is = new FileInputStream(path);

			HSSFWorkbook xw = new HSSFWorkbook(is);

			users = new ArrayList<User>();

			HSSFSheet mysheet = xw.getSheet(sheet);
			
			int j = 0;
			
			for (int rowNum = 0; rowNum < mysheet.getLastRowNum(); rowNum++) {
				HSSFRow xssfRow = mysheet.getRow(rowNum);
				if (xssfRow != null) {
					HSSFCell name = xssfRow.getCell(1);
					String userName = getValue(name);
					if(userName.equals(u.getUserName())){
						j=rowNum;
						break;
					}
				}
			}
			
			HSSFRow xssfRow = mysheet.getRow(j);
			HSSFCell id = xssfRow.createCell(0);
			HSSFCell name = xssfRow.createCell(1);
			HSSFCell pass = xssfRow.createCell(2);
			HSSFCell time = xssfRow.createCell(3);
			
			id.setCellValue(u.getId());
			name.setCellValue(u.getUserName());
			pass.setCellValue(u.getPassword());
			time.setCellValue(u.getMinTime());
			
			is.close();
			OutputStream os = new FileOutputStream(path);
			xw.write(os);
			os.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}*/
	
	private String getValue(XSSFCell cell){
		if(cell.getCellType() == cell.CELL_TYPE_BOOLEAN){
			return String.valueOf(cell.getBooleanCellValue());
		}else if(cell.getCellType() == cell.CELL_TYPE_NUMERIC){
			double number = cell.getNumericCellValue();
			int num = (int)number;
			return String.valueOf(num);
		}else{
			return String.valueOf(cell.getStringCellValue());
		}
	}
	
	private String getValue(HSSFCell cell){
		if(cell.getCellType() == cell.CELL_TYPE_BOOLEAN){
			return String.valueOf(cell.getBooleanCellValue());
		}else if(cell.getCellType() == cell.CELL_TYPE_NUMERIC){
			double number = cell.getNumericCellValue();
			int num = (int)number;
			return String.valueOf(num);
		}else{
			return String.valueOf(cell.getStringCellValue());
		}
	}
	
}
