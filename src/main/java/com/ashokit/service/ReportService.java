package com.ashokit.service;

import java.util.List;

import com.ashokit.request.SearchRequest;
import com.ashokit.response.SearchResponse;

public interface ReportService 
{
	public List<String> getPlanNames();
	
	public List<String> getPlanStatuses();
	
	public List<SearchResponse> searchPlans(SearchRequest request); // on click of search buttons ... search results 
	
	

}
