package com.ashokit.rest;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.reports.ExcelGenerator;
import com.ashokit.reports.PdfGenerator;
import com.ashokit.request.SearchRequest;
import com.ashokit.response.SearchResponse;
import com.ashokit.service.ReportService;
import com.lowagie.text.DocumentException;

@RestController
public class ReportRestController 
{
	@Autowired
	private ReportService service;
	
	@GetMapping("/planNames")
	public List<String> plannames()
	{
		return service.getPlanNames();
		
	}

	@GetMapping("/status")
	public List<String> planStatuses()
	{
		return service.getPlanStatuses();
	}
	
	@PostMapping("/search")
	public List<SearchResponse> search(@RequestBody SearchRequest request)
	{
		return service.searchPlans(request);
	}
	
	
	@GetMapping("/excel")
	public void generateExcel(HttpServletResponse response) throws IOException
	{
		
		response.setContentType("application/octet-stream");
		String headerKey= "Content-Disposition";
		String headerValue= "attachment; filename=Plans.xls";
		
		response.setHeader(headerKey, headerValue);
		
		
		List<SearchResponse> records = service.searchPlans(null);
		
		ExcelGenerator excel = new ExcelGenerator();
		
		excel.generateExcel(records, response);
		
	}
	
	@GetMapping("/pdf")
	public void generatePdf(HttpServletResponse response) throws DocumentException, IOException
	{
		
		response.setContentType("application/pdf");
		String headerKey= "Content-Disposition";
		String headerValue= "attachment; filename=Plans.pdf";
		
		response.setHeader(headerKey, headerValue);
		
		
		
		List<SearchResponse> records = service.searchPlans(null);
		
		PdfGenerator pdfGen = new PdfGenerator();

		pdfGen.generatePdf(records, response);
		
		
		
	}
}
