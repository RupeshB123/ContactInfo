package com.ashokit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ashokit.entity.EligibilityDtlsTntity;
import com.ashokit.response.SearchResponse;

@Repository
public interface EligDtlsRepository extends JpaRepository<EligibilityDtlsTntity, Integer>
{
	@Query("select distinct(planName) from  EligibilityDtlsTntity")
	public List<String> getPlanNames(); // to display data for the dropdown

	@Query("select distinct(planStatus) from EligibilityDtlsTntity")
	public List<String> getPlanStatuses();
	




}
