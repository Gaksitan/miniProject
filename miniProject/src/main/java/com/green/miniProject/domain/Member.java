package com.green.miniProject.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	private String mid;
	
	private String mpw;
	
	private String memail;
	
	private String mtel;
	
	private Date mbirthDate;
	
	private String mname;
	
	private String maddr1;

	private String maddr2;
	
	private Date mregDate;
	
	private int msate;
	
	private char mgender;
}
