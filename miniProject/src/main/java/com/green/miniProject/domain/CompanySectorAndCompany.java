package com.green.miniProject.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanySectorAndCompany {
	
	private String cno;
	private String cname;
	private String ctel;
	private String addr1;
	private String addr2;
	private String cemail;
	private LocalDate cfoundation;
	private Long cmount;
	private String cintro;
	private String ctype;
	private String cdocnum;
	private Long scno;
	private String scname;
}
