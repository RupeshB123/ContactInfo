package com.ashokit.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ashokit.entity.EligibilityDtlsTntity;
import com.ashokit.repository.EligDtlsRepository;
import com.ashokit.request.SearchRequest;
import com.ashokit.response.SearchResponse;
import com.ashokit.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService 
{
	
	@Autowired
	private EligDtlsRepository repository;
	

	@Override
	public List<String> getPlanNames() 
	{
		
		return repository.getPlanNames();
	}

	@Override
	public List<String> getPlanStatuses() 
	{

		return repository.getPlanStatuses();
	}

	@Override
	public List<SearchResponse> searchPlans(SearchRequest request) 
	{

		List<EligibilityDtlsTntity> eligRecords = null;
		
		if(isSearchReqEmpty(request))
		{
			eligRecords = repository.findAll();
		}
		else
		{
			
			// user can select any plan names and click on search button
			// user can select any plan Status and click on search button
			// user can select any plan names and any plan Status and click on search button

			// user can select start and end date and click on search button

			
			// user can select any plan names and start and end date and click on search button
			// user can select any plan status and start and end date and click on search button
			// user can select any plan names , any plan status and start and end date and click on search button

			
			EligibilityDtlsTntity entity = new EligibilityDtlsTntity();
			
			
			if(request.getPlanName()!=null && !request.getPlanName().equals("")) // not equals to null and not empty
			{
				entity.setPlanName(request.getPlanName());
			}
			
			if(request.getPlanStatus() !=null && !request.getPlanStatus().equals("")) // not equals to null and not empty
			{
				entity.setPlanStatus(request.getPlanStatus());
			}
			
			if(request.getStartDate() !=null & request.getEndDate()!=null)
			{
				entity.setStartdate(request.getStartDate());
				entity.setEndDate(request.getEndDate());
			}
			
			Example<EligibilityDtlsTntity> of = Example.of(entity); 
			
			eligRecords = repository.findAll(of);
			
		}
		
		List<SearchResponse> responseList = new ArrayList<>();
		
		for (EligibilityDtlsTntity eligRecord : eligRecords) 
		{
			SearchResponse sr = new SearchResponse();
			
			BeanUtils.copyProperties(eligRecord, sr);
			
			responseList.add(sr);
			
		}
		
		
		return responseList;
	}
	
	
	private boolean isSearchReqEmpty(SearchRequest request)
	{
		if(request.getPlanName()!=null && !request.getPlanName().equals(""))
		{
			return false;
		}
		
		if(request.getPlanStatus()!=null && !request.getPlanStatus().equals(""))
		{
			return false;
		}
		
		if(request.getStartDate()!=null && !request.getStartDate().equals(""))
		{
			return false;
		}
		
		if(request.getEndDate()!=null && !request.getEndDate().equals(""))
		{
			return false;
		}
		
		return true;
	}

}
