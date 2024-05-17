package com.green.miniProject.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Company {
	
	private String cno;
	private String cname;
	private String ctel;
	private String caddr1;
	private String caddr2;
	private String cemail;
	private LocalDate cfoundation;
	private Long camount;
	private String cintro;
	private String ctype;
	private String cdocnum;
}
