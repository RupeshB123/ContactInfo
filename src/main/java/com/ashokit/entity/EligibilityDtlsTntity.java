package com.ashokit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ELGBLITY_DTL")
public class EligibilityDtlsTntity 
{

	@Id
	@GeneratedValue
	@Column(name = "ELIG_ID")
	private Integer eligId;
	
	@Column(name="CASE_NUM")
	private Long caseNum;

	@Column(name="PLAN_NAME")
	private String planName;
	
	@Column(name = "PLAN_STATUS")
	private String planStatus;

	@Column(name = "BENEFIT_AMT")
	private Double benefitAmt;

	@Column(name = "START_DATE")
	private LocalDate startdate;
	
	@Column(name = "END_DATE")
	private LocalDate endDate;

	@Column(name = "DENIAL_REASON")
	private String denialReason;

	@Column(name = "HOLDER_NAME")
	private String holderName;
	
	@Column(name = "HOLDER_SSN")
	private Long holderSsn;

}
