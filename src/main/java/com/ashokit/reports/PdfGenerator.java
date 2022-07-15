package com.ashokit.reports;

import java.io.IOException;
import java.util.List;
import java.awt.Color;

import javax.servlet.http.HttpServletResponse;


import com.ashokit.response.SearchResponse;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfGenerator 
{
	public void generatePdf(List<SearchResponse> records, HttpServletResponse response) throws DocumentException, IOException
	{
		
		Document document = new Document();
		
		PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream()); 
		
		document.open();

		
		Font font = new Font(Font.HELVETICA, 16, Font.BOLDITALIC, Color.red);
		

		Paragraph para= new Paragraph("Eligibility Details", font);
		
		document.add(para);
		
		PdfPTable table = new PdfPTable(9);
		
		table.addCell("Sr.No");

		table.addCell("Holder Name");

		table.addCell("Holder Ssn");

		table.addCell("Plan name ");

		table.addCell("Plan Status");

		table.addCell("Start Date");

		table.addCell("End Date ");

		table.addCell("Benefit Amt");

		table.addCell("Denial Reason");
		
		
		int srNo =1;
		for (SearchResponse record : records) 
		{
			table.addCell(String.valueOf(srNo));

			table.addCell(record.getHolderName());

			table.addCell(String.valueOf (record.getHolderSsn()));

			table.addCell(record.getPlanName());

			table.addCell(record.getPlanStatus());

			table.addCell(String.valueOf(record.getStartdate()));

			table.addCell(String.valueOf(record.getEndDate()));

			table.addCell(String.valueOf(record.getBenefitAmt()));

			table.addCell(record.getDenialReason());
			
			srNo++; 
			
		}
		
		document.add(table);
		
		document.close();

		writer.close();
		
		
		
		
		
		
		
	}

}
