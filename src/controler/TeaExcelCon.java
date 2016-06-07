package controler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

import entity.Teacher;

public class TeaExcelCon {
	
	private static List<Teacher> users;
	
	/**excel 2008*/
	
	public List<Teacher> readXlsx(String path, String sheet) throws IOException {

		InputStream is = new FileInputStream(path);

		XSSFWorkbook xw = new XSSFWorkbook(is);

		users = new ArrayList<Teacher>();

		// XSSFSheet mysheet = xw.getSheetAt(0);
		XSSFSheet mysheet = xw.getSheet(sheet);
		if(mysheet == null){
			return null;
		}
		for (int rowNum = 0; rowNum <= mysheet.getLastRowNum(); rowNum++) {
			XSSFRow xssfRow = mysheet.getRow(rowNum);
			if (xssfRow != null) {
				Teacher tea = new Teacher();
				XSSFCell id = xssfRow.getCell(0);
				XSSFCell name = xssfRow.getCell(1);
				XSSFCell birthday = xssfRow.getCell(2);
				XSSFCell grade = xssfRow.getCell(3); 
				XSSFCell phoneNumber = xssfRow.getCell(4); 
				XSSFCell qq = xssfRow.getCell(5); 
				XSSFCell wechat = xssfRow.getCell(6); 
				XSSFCell abstracts = xssfRow.getCell(7); 
				XSSFCell sex = xssfRow.getCell(8); 
				XSSFCell password = xssfRow.getCell(9); 
				XSSFCell type = xssfRow.getCell(10); 
				
				if(id != null){
					tea.setTid(getValue(id));
				}
				if(name != null){
					tea.setName(getValue(name));
				}
				if(sex != null){
					tea.setSex(getValue(sex));
				}
				if(birthday != null){
					tea.setBirthday(getValue(birthday));
				}
				if(grade != null){
					tea.setGrade(getValue(grade));
				}
				if(abstracts != null){
					tea.setAbstracts(getValue(abstracts));
				}
				if(phoneNumber != null){
					tea.setPhoneNumber(getValue(phoneNumber));
				}
				if(password != null){
					tea.setPassword(getValue(password));
				}
				if(qq != null){
					tea.setQq(getValue(qq));
				}
				if(wechat != null){
					tea.setWechat(getValue(wechat));
				}
				if(type != null){
					String t = getValue(type);
					int s = Integer.parseInt(t.substring(0,1));
					tea.setType(s);
				}				
				
				users.add(tea);
			}
		}
		is.close();
		return users;
	}
	
	/**excel 2007*/
	public List<Teacher> readXls(String path, String sheet) throws IOException {

		InputStream is = new FileInputStream(path);

		HSSFWorkbook xw = new HSSFWorkbook(is);

		users = new ArrayList<Teacher>();

		// HSSFSheet mysheet = xw.getSheetAt(0);
		HSSFSheet mysheet = xw.getSheet(sheet);
		
		if(mysheet == null){
			return null;
		}

		for (int rowNum = 0; rowNum <= mysheet.getLastRowNum(); rowNum++) {
			HSSFRow hssfRow = mysheet.getRow(rowNum);
			if (hssfRow != null) {
				Teacher tea = new Teacher();
				HSSFCell id = hssfRow.getCell(0);
				HSSFCell name = hssfRow.getCell(1);
				HSSFCell birthday = hssfRow.getCell(2);
				HSSFCell grade = hssfRow.getCell(3); 
				HSSFCell phoneNumber = hssfRow.getCell(4); 
				HSSFCell qq = hssfRow.getCell(5); 
				HSSFCell wechat = hssfRow.getCell(6); 
				HSSFCell abstracts = hssfRow.getCell(7); 
				HSSFCell sex = hssfRow.getCell(8); 
				HSSFCell password = hssfRow.getCell(9); 
				HSSFCell type = hssfRow.getCell(10); 
				
				if(id != null){
					tea.setTid(getValue(id));
				}
				if(name != null){
					tea.setName(getValue(name));
				}
				if(sex != null){
					tea.setSex(getValue(sex));
				}
				if(birthday != null){
					tea.setBirthday(getValue(birthday));
				}
				if(grade != null){
					tea.setGrade(getValue(grade));
				}
				if(abstracts != null){
					tea.setAbstracts(getValue(abstracts));
				}
				if(phoneNumber != null){
					tea.setPhoneNumber(getValue(phoneNumber));
				}
				if(password != null){
					tea.setPassword(getValue(password));
				}
				if(qq != null){
					tea.setQq(getValue(qq));
				}
				if(wechat != null){
					tea.setWechat(getValue(wechat));
				}
				if(type != null){
					String t = getValue(type);
					int s = Integer.parseInt(t.substring(0,1));
					tea.setType(s);
				}
				
				users.add(tea);
			}
		}
		is.close();
		return users;
	}
	
	/*public void updateXlsx(String path, String sheet, Teacher u){
		try{
			InputStream is = new FileInputStream(path);

			XSSFWorkbook xw = new XSSFWorkbook(is);

			users = new ArrayList<Teacher>();

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
	public void updateXls(String path, String sheet, Teacher u){
		try{
			InputStream is = new FileInputStream(path);

			HSSFWorkbook xw = new HSSFWorkbook(is);

			users = new ArrayList<Teacher>();

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
