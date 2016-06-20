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

public class ScExcelCon {
	
	private List<String> list = null;

	public List<String> readXlsx(String path, String sheet) throws IOException {

		InputStream is = new FileInputStream(path);

		XSSFWorkbook xw = new XSSFWorkbook(is);

		list = new ArrayList<String>();

		// XSSFSheet mysheet = xw.getSheetAt(0);
		XSSFSheet mysheet = xw.getSheet(sheet);
		if(mysheet == null){
			return null;
		}
		
		for (int rowNum = 0; rowNum <= mysheet.getLastRowNum(); rowNum++) {
			XSSFRow xssfRow = mysheet.getRow(rowNum);
			if (xssfRow != null) {
				//Student stu = new Student();
				XSSFCell id = xssfRow.getCell(0); 
				String sid = getValue(id);
				list.add(sid);
			}
		}
		is.close();
		return list;
	}
	
	/**excel 2007*/
	public List<String> readXls(String path, String sheet) throws IOException {

		InputStream is = new FileInputStream(path);

		HSSFWorkbook xw = new HSSFWorkbook(is);

		list = new ArrayList<String>();

		// HSSFSheet mysheet = xw.getSheetAt(0);
		HSSFSheet mysheet = xw.getSheet(sheet);

		if(mysheet == null){
			return null;
		}
		
		for (int rowNum = 0; rowNum <= mysheet.getLastRowNum(); rowNum++) {
			HSSFRow hssfRow = mysheet.getRow(rowNum);
			if (hssfRow != null) {
			
				HSSFCell id = hssfRow.getCell(0);
				 
				String sid = getValue(id);
					
				list.add(sid);
			}
		}
		is.close();
		return list;
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
