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
public class Member {
	private String mid;
	
	private String mpw;
	
	private String memail;
	
	private String mtel;
	
	private LocalDate mbirthDate;
	
	private String mname;
	
	private String maddr1;

	private String maddr2;
	
	private LocalDate mregDate;
	
	private int mstate;
	
	private char mgender;
}
