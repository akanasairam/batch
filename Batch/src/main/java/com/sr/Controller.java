package com.sr;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.Document;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class Controller {

	@Autowired
	private JobLauncher l;

	@Autowired
	private Job j;

	@GetMapping("/a")
	public List<Purchase> get(HttpServletRequest req, HttpServletResponse resp) throws IOException {
FileInputStream fis=new FileInputStream("C:\\Users\\springlogix\\Desktop\\data.xlsx");

InputStream is=fis;

		XSSFWorkbook w = new XSSFWorkbook(is);

	XSSFSheet s=w.getSheetAt(0);
	List<Row>list=new ArrayList<Row>();
	for(int i=0;i<s.getPhysicalNumberOfRows();i++) {
		list.add(s.getRow(i));
	}
	
	
	List<Purchase> l=new ArrayList<Purchase>();
	for(int i=0;i<list.size();i++) {
		if(i==0) {
			continue;
		}
		Row r=list.get(i);
		l.add(new Purchase(r.getCell(0).getDateCellValue(),r.getCell(1).getStringCellValue(),r.getCell(2).getNumericCellValue(),
				r.getCell(3).getStringCellValue(),r.getCell(4).getNumericCellValue()));
	}
	
		
		  
		  
		  return l;
		  }
	@GetMapping("/b")
	public void b(HttpServletResponse res,HttpServletRequest req) throws IOException {
		
		XSSFWorkbook w=new XSSFWorkbook();
		XSSFSheet s=w.createSheet("Template");
		String b[]= {"date","dl","da","cl","ca","narration"};
		Row r=s.createRow(0);
		for(int i=0;i<b.length;i++) {
			r.createCell(i).setCellValue(b[i]);
		}
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		w.write(bos);
		
		OutputStream os=res.getOutputStream();
		os.write(bos.toByteArray());
		res.setHeader("Content-Disposition", "attachment; filename=ptemplate.xlsx");
		
		return ;
	}
}
