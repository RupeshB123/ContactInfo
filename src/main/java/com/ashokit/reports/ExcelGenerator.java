package com.ashokit.reports;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.ashokit.response.SearchResponse;

public class ExcelGenerator 
{
	public void generateExcel(List<SearchResponse> response, HttpServletResponse httpResponse) throws IOException
	{
		// List<SearchResponse> response ---
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("PLANS");
		HSSFRow headerRow = sheet.createRow(0);
		
		headerRow.createCell(0).setCellValue("sr.No");
		headerRow.createCell(1).setCellValue("HolderName");
		headerRow.createCell(2).setCellValue("Holder SSN");
		headerRow.createCell(3).setCellValue("PLAN NAME");
		headerRow.createCell(4).setCellValue("PLAN STATUS");
		headerRow.createCell(5).setCellValue("START DATE");
		headerRow.createCell(6).setCellValue("END DATE");
		headerRow.createCell(7).setCellValue("BENEFIT AMT");
		headerRow.createCell(8).setCellValue("DENIAL REASON");
		
		
		for(int i =0 ; i<response.size(); i++)
		{
			HSSFRow dataRow = sheet.createRow(i+1);
			SearchResponse record = response.get(i);
			
			dataRow.createCell(0).setCellValue(i+1);
			
			if(record.getHolderName() !=null)
			dataRow.createCell(1).setCellValue(record.getHolderName());
			
			if(record.getHolderSsn()!=null)
			dataRow.createCell(2).setCellValue(record.getHolderSsn());
			
			if(record.getPlanName()!=null)
			dataRow.createCell(3).setCellValue(record.getPlanName());
			
			if(record.getPlanStatus()!=null)
			dataRow.createCell(4).setCellValue(record.getPlanStatus());

			
			if(record.getStartdate()!=null)
			dataRow.createCell(5).setCellValue(String.valueOf(record.getStartdate()) );
			
			
			if(record.getEndDate()!=null)
			dataRow.createCell(6).setCellValue(String.valueOf(record.getEndDate()) );
		
			if(record.getBenefitAmt()!=null)
			dataRow.createCell(7).setCellValue(String.valueOf(record.getBenefitAmt()));
		
			if(record.getDenialReason()!=null)
			dataRow.createCell(8).setCellValue(record.getDenialReason());
		
		}
		
		workbook.write(httpResponse.getOutputStream());
		workbook.close();
		
	}

}
